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

package com.chenlb.study_trails.hadoop;

import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * @author chenlb 2017-08-17 20:55
 */
public class ExampleTest {

	@Test
	@Ignore
	public void runSequenceFileWriteDemo() throws IOException {
		SequenceFileWriteDemo.main("output/numbers.seq".split(" "));
	}

	@Test
	@Ignore
	public void runSequenceFileReadDemo() throws IOException {
		SequenceFileReadDemo.main("output/numbers.seq".split(" "));
	}
}
