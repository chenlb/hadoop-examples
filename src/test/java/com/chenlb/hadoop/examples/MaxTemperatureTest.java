/*
 * Copyright 2017 chenlb
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

package com.chenlb.hadoop.examples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenlb
 * @create 2017-08-18 18:32
 */
public class MaxTemperatureTest {

	@Test
	public void processesValidRecord() throws IOException {
		Text value = new Text("2017-08-18,杭州,29,34");

		new MapDriver<LongWritable, Text, Text, IntWritable>()
				.withMapper(new MaxTemperatureMapper())
				.withInput(new LongWritable(0), value)
				.withOutput(new Text("2017"), new IntWritable(34))
				.runTest();
	}

	@Test
	public void returnsMaxIntegerInValues() throws IOException {

		new ReduceDriver<Text, IntWritable, Text, IntWritable>()
				.withReducer(new MaxTemperatureReducer())
				.withInput(new Text("2017"),
						Arrays.asList(new IntWritable(10), new IntWritable(5)))
				.withOutput(new Text("2017"), new IntWritable(10))
				.runTest();
	}

	@Test
	public void test_max_temperature_driver() throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "file:///");
		conf.set("mapreduce.framework.name", "local");
		conf.setInt("mapreduce.task.io.sort.mb", 1);

		Path input = new Path("example-resources/temperature");
		Path output = new Path("output");

		FileSystem fs = FileSystem.getLocal(conf);
		fs.delete(output, true);

		MaxTemperatureDriver driver = new MaxTemperatureDriver();
		driver.setConf(conf);

		int exitCode = driver.run(new String[] {
			input.toString(), output.toString()
		});

		Assert.assertEquals(exitCode, 0);

		checkOutput(fs, conf, output, new String[] {
				"2016\t35",
				"2017\t34"
		});
	}

	private void checkOutput(FileSystem fs, Configuration conf, Path output, String... lines) throws IOException {

		InputStream in = null;
		try {
			in = fs.open(new Path(output, "part-r-00000"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			List<String> rLines = new ArrayList<>();
			String line = null;
			while((line = reader.readLine()) != null) {
				rLines.add(line);
			}

			Assert.assertArrayEquals(rLines.toArray(), lines);
		} finally {
			IOUtils.closeStream(in);
		}
	}
}
