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

package com.chenlb.study_trails.hive_sql;

import org.antlr.v4.runtime.CharStreams;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.regex.Matcher;

/**
 * @author chenlb 2018-05-18 20:32
 */
public class LineageInfoTest {

	private static Charset UTF8 = Charset.forName("utf-8");

	@Test
	public void test_match_set() {
		String[] strs = {
				"SET hive.mapred.supports.subdirectories=TRUE;",
				"set mapreduce.input.fileinputformat.input.dir.recursive=true;",
				"Set abc=123;"
		};
		for(String setStr : strs) {
			Matcher matcher = LineageInfo.SET_PATTERN.matcher(setStr);
			Assert.assertTrue(matcher.find());
		}
	}

	private LineageInfo.LineageResult getLineage(String path) throws IOException, SemanticException, ParseException {
		LineageInfo lep = new LineageInfo();
		LineageInfo.LineageResult result = lep.getLineageInfo(CharStreams.fromStream(this.getClass().getResourceAsStream("/"+path), UTF8));
		return result;
	}

	@Test
	public void test_lineage() throws IOException, SemanticException, ParseException {
		//test_for_lineage.hsql
		LineageInfo.LineageResult result = getLineage("test_for_lineage.hsql");
		//System.out.println(result);

		LineageInfo.LineageResult assertResult = new LineageInfo.LineageResult();
		assertResult.addInputTable("my_db2.my_table_2");
		assertResult.addInputTable("my_db.other_input_table");
		assertResult.addOutputTable("default.test_for_lineage");

		System.out.println(result);
		Assert.assertEquals(assertResult, result);

		result = getLineage("test_for_lineage_multi.hsql");
		assertResult = new LineageInfo.LineageResult();
		assertResult.addInputTable("default.ods_xxx");
		assertResult.addInputTable("dw.t_c_table_1");
		assertResult.addInputTable("dw.t_c_table_2");
		assertResult.addInputTable("my_db.dump_table_1");
		assertResult.addInputTable("my_db.r_dd_table_3");

		assertResult.addOutputTable("dw.t_c_table_2");
		assertResult.addOutputTable("dw.t_c_table_4");
		assertResult.addOutputTable("my_db.t_c_table_1");

		Assert.assertEquals(assertResult, result);
	}
}
