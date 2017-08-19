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
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.net.URI;

/**
 * @author chenlb
 * @create 2017-08-17 20:54
 */
public class SequenceFileWriteDemo {

	private static final String[] DATA = {
			"第一行，测试顺利文件",
			"第二行，写 Sequence 文件",
			"第三行，标准输出",
			"第四行，读取 SequenceFile",
			"第五行，Junit 运行"
	};

	/**
	 * <code>
	 *     hadoop com.chenlb.hadoop.examples.SequenceFileWriteDemo output/numbers.seq
	 * </code>
	 * @param args 顺序文件写入的文件，如：output/numbers.seq
	 */
	public static void main(String[] args) throws IOException {
		String uri = args[0];
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create(uri), conf);
		Path path = new Path(uri);

		IntWritable key = new IntWritable();
		Text value = new Text();
		SequenceFile.Writer writer = null;

		try {
			writer = SequenceFile.createWriter(fs, conf, path, key.getClass(), value.getClass());
			for(int i=0; i<100; i++) {
				key.set(100 - i);
				value.set(DATA[i % DATA.length]);
				System.out.printf("[%s]\t%s\t%s\n", writer.getLength(), key, value);
				writer.append(key, value);
			}
		} finally {
			IOUtils.closeStream(writer);
		}
	}
}
