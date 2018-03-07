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

package com.chenlb.study_trails.antlr4;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenlb 2018-03-07 21:49
 */
public class SqlSplitTest {

	public static List<String> splitSqlStatment(String sqlClauses) {
		List<String> stats = Collections.EMPTY_LIST;

		SqlSplitParser parser = new SqlSplitParser(new CommonTokenStream(new SqlSplitLexer(CharStreams.fromString(sqlClauses))));

		SqlSplitParser.Sql_clausesContext sqls = parser.sql_clauses();

		stats = new ArrayList<String>();

		for(SqlSplitParser.Sql_clauseContext sql : sqls.sql_clause()) {
			stats.add(sql.getText());
		}
		return stats;
	}

	private void sql_clauses(String sqlFile) {
		List<String> sqls = splitSqlStatment(sqlFile);
		Assert.assertTrue(sqls.size() > 0);

		System.out.println("size: "+sqls.size());
		for(String sql : sqls) {
			System.out.println("sql:["+sql+"]");
		}
	}

	@Test
	public void test_sql_clauses() {
		String sqlFile = "use abc;\n"
				+ "select \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6)\" as op_name";

		sql_clauses(sqlFile);

		sql_clauses(";\t\n;\t   \n;select 'a,b,c,;',ef,'文',\"中\" from abc where a=1 having c()>3;a;中文;");
		sql_clauses("--测试注释\nselect 'a,b,c,;',ef,'文',\"中\" /* 多行 comment */ from abc where a=1 having c()>3;");
	}
}
