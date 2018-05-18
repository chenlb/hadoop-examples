/*
 * Copyright 2018 chenlb
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.chenlb.study_trails.avro.jobhistory;

import org.apache.avro.Schema;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.hadoop.mapreduce.jobhistory.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenlb 2018-04-15 17:16
 */
public class ReadJobHistory {

	private static final Logger logger = LoggerFactory.getLogger(ReadJobHistory.class);

	// AM_STARTED@org.apache.hadoop.mapreduce.jobhistory.AMStarted, size=1
	// JOB_INITED@org.apache.hadoop.mapreduce.jobhistory.JobInited, size=1
	// JOB_SUBMITTED@org.apache.hadoop.mapreduce.jobhistory.JobSubmitted, size=1
	// JOB_QUEUE_CHANGED@org.apache.hadoop.mapreduce.jobhistory.JobQueueChange, size=1
	// JOB_INFO_CHANGED@org.apache.hadoop.mapreduce.jobhistory.JobInfoChange, size=1
	//
	// TASK_STARTED@org.apache.hadoop.mapreduce.jobhistory.TaskStarted, size=150
	//
	// MAP_ATTEMPT_STARTED@org.apache.hadoop.mapreduce.jobhistory.TaskAttemptStarted, size=100
	// MAP_ATTEMPT_FINISHED@org.apache.hadoop.mapreduce.jobhistory.MapAttemptFinished, size=100
	// REDUCE_ATTEMPT_STARTED@org.apache.hadoop.mapreduce.jobhistory.TaskAttemptStarted, size=50
	// REDUCE_ATTEMPT_FINISHED@org.apache.hadoop.mapreduce.jobhistory.ReduceAttemptFinished, size=50
	//
	// TASK_FINISHED@org.apache.hadoop.mapreduce.jobhistory.TaskFinished, size=150
	// JOB_FINISHED@org.apache.hadoop.mapreduce.jobhistory.JobFinished, size=1

	private AMStarted amStarted;
	private JobInited jobInited;
	private JobSubmitted jobSubmitted;
	private JobQueueChange jobQueueChange;
	private JobInfoChange jobInfoChange;

	private Map<CharSequence, TaskStarted> taskStartedMap = new HashMap<>();

	private Map<CharSequence, TaskAttemptStarted> mapAttemptStartedMap = new HashMap<>();
	private Map<CharSequence, MapAttemptFinished> mapAttemptFinishedMap = new HashMap<>();

	private Map<CharSequence, TaskAttemptStarted> reduceAttemptStartedMap = new HashMap<>();
	private Map<CharSequence, ReduceAttemptFinished> reduceAttemptFinishedMap = new HashMap<>();

	private Map<CharSequence, TaskFinished> taskFinishedMap = new HashMap<>();

	private JobFinished jobFinished;

	private List<Event> unknowEvent = new ArrayList<>();

	private boolean printTask = true;
	private boolean printJob = false;

	public void setPrintTask(boolean printTask) {
		this.printTask = printTask;
	}

	public void readJob(File jhistFile, OutputStream out) throws IOException {
		try(FileInputStream fin = new FileInputStream(jhistFile);
				DataInputStream din = new DataInputStream(fin)) {



			//跳过一行， Avro-Json
			String fileMagic = din.readLine();
			if(!"Avro-Json".equals(fileMagic)) {
				throw new IOException("not avro json file!");
			}

			//scheam
			String avsc = din.readLine();

			Schema schema = null;

			SpecificDatumReader<Event> datumReader = null;

			schema = new Schema.Parser().parse(avsc);
			//datumReader = new GenericDatumReader<>(schema);
			datumReader = new SpecificDatumReader<>(Event.class);

			Decoder decoder = DecoderFactory.get().jsonDecoder(schema, din);

			while(true) {
				try {
					Event record = datumReader.read(null, decoder);

					EventType key = record.getType();

					switch (key) {
					case AM_STARTED:
						amStarted = (AMStarted) record.getEvent();
						break;
					case JOB_INITED:
						jobInited = (JobInited) record.getEvent();
						break;
					case JOB_SUBMITTED:
						jobSubmitted = (JobSubmitted) record.getEvent();
						break;
					case JOB_QUEUE_CHANGED:
						jobQueueChange = (JobQueueChange) record.getEvent();
						break;
					case JOB_INFO_CHANGED:
						jobInfoChange = (JobInfoChange) record.getEvent();
						break;
					case TASK_STARTED:
						TaskStarted ts = (TaskStarted) record.getEvent();
						taskStartedMap.put(ts.getTaskid(), ts);
						break;
					case MAP_ATTEMPT_STARTED:
						TaskAttemptStarted mas = (TaskAttemptStarted) record.getEvent();
						mapAttemptStartedMap.put(mas.getAttemptId(), mas);
						break;
					case MAP_ATTEMPT_FINISHED:
						MapAttemptFinished maf = (MapAttemptFinished) record.getEvent();
						mapAttemptFinishedMap.put(maf.getAttemptId(), maf);
						break;
					case REDUCE_ATTEMPT_STARTED:
						TaskAttemptStarted ras = (TaskAttemptStarted) record.getEvent();
						reduceAttemptStartedMap.put(ras.getAttemptId(), ras);
						break;
					case REDUCE_ATTEMPT_FINISHED:
						ReduceAttemptFinished raf = (ReduceAttemptFinished) record.getEvent();
						reduceAttemptFinishedMap.put(raf.getAttemptId(), raf);
						break;
					case TASK_FINISHED:
						TaskFinished tf = (TaskFinished) record.getEvent();
						taskFinishedMap.put(tf.getTaskid(), tf);
						break;
					case JOB_FINISHED:
						jobFinished = (JobFinished) record.getEvent();
						break;
						default:
							unknowEvent.add(record);
							break;
					}
				} catch (EOFException e) {
					break;
				}
			}

			if(jobFinished != null) {
				MapTaskCounter totalMapTaskCounter = new MapTaskCounter(jobFinished.getJobid(), jobFinished.getJobid());
				totalMapTaskCounter.setTime(jobInfoChange.getLaunchTime(), jobFinished.getFinishTime());

				for(MapAttemptFinished maf : mapAttemptFinishedMap.values()) {
					TaskAttemptStarted mas = mapAttemptStartedMap.get(maf.getAttemptId());

					MapTaskCounter mapTaskCounter = new MapTaskCounter(maf.getTaskid(), maf.getAttemptId());
					mapTaskCounter.setTime(mas.getStartTime(), maf.getFinishTime());

					sumCount(mapTaskCounter, maf.getCounters());

					if(printTask) {
						if(!mapTaskCounter.printLine(out)) {
							logger.warn("Not_HDFS_BYTES_READ t={}", mapTaskCounter.taskId);
						}
					}
				}

				sumCount(totalMapTaskCounter, jobFinished.getMapCounters());

				if(printJob) {
					if(!totalMapTaskCounter.printLine(out)) {
						logger.warn("Not_HDFS_BYTES_READ f={}", jhistFile);
					}
				}
			}
		}
	}

	protected void sumCount(MapTaskCounter mapTaskCounter, JhCounters counters) {
		List<JhCounterGroup> groups = counters.getGroups();
		for(JhCounterGroup group : groups) {
			//System.out.println("\t"+group.getName());
			List<JhCounter> counts = group.getCounts();
			for(JhCounter count : counts) {
				//System.out.println("\t\t"+count.getName()+"="+count.getValue());
				mapTaskCounter.addCount(count);
			}
		}
	}

	public static class MapTaskCounter {
		CharSequence taskId;
		CharSequence attemptId;
		long startTime;
		long finishTime;
		Map<String, AtomicLong> counters = new HashMap<>();

		public MapTaskCounter(CharSequence taskId, CharSequence attemptId) {
			this.taskId = taskId;
			this.attemptId = attemptId;
		}

		public void addCount(JhCounter count) {
			String key = String.valueOf(count.getName());
			AtomicLong atomicLong = counters.get(key);
			if(atomicLong == null) {
				atomicLong = new AtomicLong();
				counters.put(key, atomicLong);
			}
			atomicLong.addAndGet(count.getValue());
		}

		public void setTime(long startTime, long finishTime) {
			this.startTime = startTime;
			this.finishTime = finishTime;
		}

		public boolean printLine(OutputStream out) throws IOException {
			String line = printLine();
			if(line != null) {
				out.write(line.getBytes("utf-8"));
			}
			return line != null;
		}

		public String printLine() {
			AtomicLong hdfs_bytes_read = counters.get("HDFS_BYTES_READ");
			if(hdfs_bytes_read == null) {
				return null;
			}
			long ut = finishTime - startTime;
			String line = taskId+","+ut;
			long byteSize = hdfs_bytes_read.longValue();
			line += ","+byteSize+","+(byteSize/(ut/1000)/1024);
			//line += ","+startTime+","+finishTime;
			line += "\n";
			return line;
		}
	}

	protected static File[] listJhistFile(File parentFile) {
		return  parentFile.listFiles(new FilenameFilter() {
			@Override public boolean accept(File dir, String name) {
				return name.endsWith(".jhist") && !name.contains("-distcp-");
			}
		});
	}

	protected static void doReadJob(File[] fs, OutputStream out) {
		for(File f : fs) {
			ReadJobHistory rjh = new ReadJobHistory();
			try {
				rjh.readJob(f, out);
			} catch (IOException e) {
				logger.warn("read_error f={}, {}", f, e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		String basePath = args[0];
		String saveFile = basePath+"-jhist-result.txt";

		if(basePath.endsWith("/*")) {
			//两层目录
			basePath = basePath.substring(0, basePath.length()-2);
			File[] pfs = new File(basePath).listFiles(new FileFilter() {
				@Override public boolean accept(File pathname) {
					return pathname.isDirectory();
				}
			});

			saveFile = basePath+"/jhist-result.txt";

			File fw = new File(saveFile);
			BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(fw));
			try {
				for(File f : pfs) {
					File[] fs = listJhistFile(f);
					doReadJob(fs, fout);
				}
			} finally {
				fout.close();
			}
		} else {
			if(basePath.endsWith("/")) {
				saveFile = basePath.substring(0, basePath.length()-1)+"-jhist-result.txt";
			}

			File[] fs = listJhistFile(new File(basePath));

			File fw = new File(saveFile);
			BufferedOutputStream fout = new BufferedOutputStream(new FileOutputStream(fw));
			try {
				doReadJob(fs, fout);
			} finally {
				fout.close();
			}
		}


	}
}
