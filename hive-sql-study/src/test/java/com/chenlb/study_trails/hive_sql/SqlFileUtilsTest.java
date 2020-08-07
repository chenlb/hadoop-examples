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

import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.hive.ql.parse.ParseException;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenlb 2018-05-19 14:59
 */
public class SqlFileUtilsTest {

	private String join(String split, String ... statments) {
		if(statments.length == 1) {
			return "";
		}

		if(statments.length == 1) {
			return statments[0];
		}

		StringBuilder sb = new StringBuilder();

		for(int i=0; i<statments.length-1; i++) {
			String statment = statments[i];
			sb.append(statment).append(split);
		}

		sb.append(statments[statments.length - 1]);

		return sb.toString();
	}

	private void assertSqlsEqule(String[] esql, List<String> asql) {
		Assert.assertTrue(esql.length <= asql.size());
		for(int i=0, j=0; i<esql.length; j++) {
			String esqlv = StringUtils.stripToEmpty(esql[i]);
			String asqlv = StringUtils.stripToEmpty(asql.get(j));

			if(!StringUtils.isEmpty(asqlv)) {
				i++;
				Assert.assertEquals(esqlv, asqlv);
			}
		}
	}

	@Test
	public void test_splitSqlStatment() {
		String[][] sqls = {
				new String[] {
					"use my_db",
					"select \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6)\" as op_name"
				},
				new String[] {
						"", "\t", "\t\n",
						"select 'a,b,c,;',ef,'文',\"中\" from abc where a=1 having c()"
				},
				new String[] {
						"--测试注释",
						"use other_db --使用库名",
						"/*\n 多行 */",
						"select 'a,b,c,;',ef,'文',\"中\" /* 多行 comment */ from abc where a=1 having c()>3"
				}
		};

		String[][] assertSqls = {
				sqls[0],
				new String[] {
						"select 'a,b,c,;',ef,'文',\"中\" from abc where a=1 having c()"
				},
				new String[] {
						"use other_db",
						"select 'a,b,c,;',ef,'文',\"中\"  from abc where a=1 having c()>3"
				}
		};

		for(int i=0; i<sqls.length; i++) {
			String[] sqlFile = sqls[i];
			String sql = join(";\n", sqlFile);
			List<String> my_sqls = SqlFileUtils.splitSqlStatment(sql);
			assertSqlsEqule(assertSqls[i], my_sqls);
		}

		//测试空
		List<String> sqlStrs = SqlFileUtils.splitSqlStatment("");
		Assert.assertEquals(0, sqlStrs.size());
		sqlStrs = SqlFileUtils.splitSqlStatment(";");
		Assert.assertEquals(0, sqlStrs.size());
	}

	@Test
	public void test_semi_in_string() throws ParseException, SemanticException {
		String sql = "select 'abc;123', '123', '中文; eng'";

		List<String> semiInString = SqlFileUtils.findSemiInString(sql);

		List<String> assertList = new ArrayList<>();
		assertList.add("'abc;123'");
		assertList.add("'中文; eng'");

		Assert.assertEquals(assertList, semiInString);
	}
}
