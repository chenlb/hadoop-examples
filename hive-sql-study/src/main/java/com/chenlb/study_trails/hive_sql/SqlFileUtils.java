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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenlb 2018-05-19 11:28
 */
public class SqlFileUtils {

	public static List<String> splitSqlStatment(String sqlFile) {
		return splitSqlStatment(CharStreams.fromString(sqlFile));
	}

	/**
	 * 按 ';' 切换 sql 语句
	 * @param sqlFile sql 文件
	 * @return 切分好的单条 sql 列表
	 */
	public static List<String> splitSqlStatment(CharStream sqlFile) {
		List<String> statments = Collections.EMPTY_LIST;

		statments = new ArrayList<String>();

		for (SqlFileParser.SqlClauseContext sql : sqlClauses(sqlFile)) {
			String sqlStr = StringUtils.trimToEmpty(sql.getText());
			if(StringUtils.isNotEmpty(sqlStr)) {
				statments.add(sqlStr);
			}
		}
		return statments;
	}

	public static List<SqlFileParser.SqlClauseContext> sqlClauses(String sqlFile) {
		return sqlClauses(CharStreams.fromString(sqlFile));
	}

	public static List<SqlFileParser.SqlClauseContext> sqlClauses(CharStream sqlFile) {
		SqlFileParser parser = new SqlFileParser(new CommonTokenStream(new SqlFileLexer(sqlFile)));

		SqlFileParser.SqlClausesContext sqlClausesContext = parser.sqlClauses();

		return sqlClausesContext.sqlClause();
	}

	public static List<String> findSemiInString(String sqlFile) {
		return findSemiInString(CharStreams.fromString(sqlFile));
	}

	/**
	 * 在 sql 文件里找有 ';' sql 字符串地方。
	 * @param sqlFile  sql 文件
	 * @return 含有 ';' 的 sql 字符串。
	 */
	public static List<String> findSemiInString(CharStream sqlFile) {
		List<String> semiStrings = new ArrayList<>();
		List<SqlFileParser.SqlClauseContext> sqlClauseContexts = sqlClauses(sqlFile);
		for(SqlFileParser.SqlClauseContext sqlClauseContext : sqlClauseContexts) {
			List<TerminalNode> strings = sqlClauseContext.STRING();
			for(TerminalNode strNode : strings) {
				String str = strNode.getText();
				if(str.contains(";")) {
					semiStrings.add(str);
				}
			}
		}
		return semiStrings;
	}
}
