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
import org.apache.hadoop.hive.ql.lib.*;
import org.apache.hadoop.hive.ql.parse.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * edit from {@link org.apache.hadoop.hive.ql.tools.LineageInfo}
 * @author chenlb 2018-05-18 22:01
 */
public class LineageInfo implements NodeProcessor {

	private static final Logger logger = LoggerFactory.getLogger(LineageInfo.class);


	String currentDatabase;

	/**
	 * Stores input tables in sql.
	 */
	TreeSet<String> inputTableList = new TreeSet<String>();
	/**
	 * Stores output tables in sql.
	 */
	TreeSet<String> outputTableList = new TreeSet<String>();

	/**
	 *
	 * @return java.util.TreeSet
	 */
	public TreeSet<String> getInputTableList() {
		return inputTableList;
	}

	/**
	 * @return java.util.TreeSet
	 */
	public TreeSet<String> getOutputTableList() {
		return outputTableList;
	}

	public String getCurrentDatabase() {
		return currentDatabase;
	}

	protected String getFirstUnescapedName(ASTNode pt) {
		return BaseSemanticAnalyzer.getUnescapedName((ASTNode)pt.getChild(0));
	}

	protected String getTableName(ASTNode pt) {
		ASTNode tabTree = (ASTNode) pt.getChild(0);
		String table_name = (tabTree.getChildCount() == 1) ?
				BaseSemanticAnalyzer.getUnescapedName((ASTNode)tabTree.getChild(0)) :
				BaseSemanticAnalyzer.getUnescapedName((ASTNode)tabTree.getChild(0)) + "." + tabTree.getChild(1);
		return table_name;
	}

	/**
	 * Implements the process method for the NodeProcessor interface.
	 */
	@Override
	public Object process(Node nd, Stack<Node> stack, NodeProcessorCtx procCtx, Object... nodeOutputs) throws SemanticException {
		ASTNode pt = (ASTNode) nd;

		switch (pt.getToken().getType()) {

		case HiveParser.TOK_TABREF:
			String table_name = getTableName(pt);
			inputTableList.add(table_name);
			break;
		case HiveParser.TOK_TAB:
			outputTableList.add(getFirstUnescapedName(pt));
			break;
		case HiveParser.TOK_CREATETABLE:
			outputTableList.add(getTableName(pt));
			break;
		case HiveParser.TOK_SWITCHDATABASE:
			currentDatabase = getFirstUnescapedName(pt);
			break;
		default:
			/*
			if(logger.isDebugEnabled()) {
				logger.debug("token_type={}, txt={}", pt.getToken().getType(), pt);
			}*/
			break;
		}

		return null;
	}

	private void clear() {
		inputTableList.clear();
		outputTableList.clear();
	}

	/**
	 * parses given query and gets the lineage info.
	 *
	 * @param query
	 * @throws ParseException
	 */
	protected void dumpLineageInfo(String query) throws ParseException, SemanticException {

		/*
		 * Get the AST tree
		 */
		ParseDriver pd = new ParseDriver();
		ASTNode tree = pd.parse(query);

		while ((tree.getToken() == null) && (tree.getChildCount() > 0)) {
			tree = (ASTNode) tree.getChild(0);
		}

		/*
		 * initialize Event Processor and dispatcher.
		 */
		clear();

		// create a walker which walks the tree in a DFS manner while maintaining
		// the operator stack. The dispatcher
		// generates the plan from the operator tree
		Map<Rule, NodeProcessor> rules = new LinkedHashMap<Rule, NodeProcessor>();

		// The dispatcher fires the processor corresponding to the closest matching
		// rule and passes the context along
		Dispatcher disp = new DefaultRuleDispatcher(this, rules, null);
		GraphWalker ogw = new DefaultGraphWalker(disp);

		// Create a list of topop nodes
		ArrayList<Node> topNodes = new ArrayList<Node>();
		topNodes.add(tree);
		ogw.startWalking(topNodes, null);
	}

	private String normalizeTableName(String tableName) {
		if(currentDatabase != null) {
			if(!tableName.contains(".")) {
				return currentDatabase + "." + tableName;
			}
		}
		return tableName;
	}

	public static class LineageResult {
		private TreeSet<String> inputTable = new TreeSet<String>();
		private TreeSet<String> outputTable = new TreeSet<String>();

		public void addInputTable(String table) {
			inputTable.add(table);
		}

		public void addOutputTable(String table) {
			outputTable.add(table);
		}

		public TreeSet<String> getInputTable() {
			return inputTable;
		}

		public TreeSet<String> getOutputTable() {
			return outputTable;
		}

		@Override public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			LineageResult result = (LineageResult) o;
			return Objects.equals(inputTable, result.inputTable) &&
					Objects.equals(outputTable, result.outputTable);
		}

		@Override public int hashCode() {

			return Objects.hash(inputTable, outputTable);
		}

		@Override public String toString() {
			return "LineageResult{" +
					"inputTable=" + inputTable +
					", outputTable=" + outputTable +
					'}';
		}
	}

	/**
	 * sql 文件，有多条 hive sql
	 * @param sqlFile  用 ';' 分隔的 sql 文件
	 * @throws ParseException
	 * @throws SemanticException
	 */
	public LineageResult getLineageInfo(String sqlFile) throws ParseException, SemanticException {
		return getLineageInfo(CharStreams.fromString(sqlFile));
	}

	protected static Pattern SET_PATTERN = Pattern.compile("^[sS][eE][tT] ");

	/**
	 * sql 文件，有多条 hive sql
	 * @param sqlFile  用 ';' 分隔的 sql 文件
	 * @throws ParseException
	 * @throws SemanticException
	 */
	public LineageResult getLineageInfo(CharStream sqlFile) throws ParseException, SemanticException {
		List<String> statments = SqlFileUtils.splitSqlStatment(sqlFile);

		LineageResult result = new LineageResult();

		for(String query : statments) {
			Matcher matcher = SET_PATTERN.matcher(query);
			if(matcher.find()) {
				//set 跳过
				continue;
			}
			try {
				dumpLineageInfo(query);
			} catch (ParseException e) {
				logger.warn("parse_sql_fail, sql=[{}]", query);
				throw e;
			}

			for(String table : inputTableList) {
				result.addInputTable(normalizeTableName(table));
			}

			for(String table : outputTableList) {
				result.addOutputTable(normalizeTableName(table));
			}
		}

		return result;
	}
}
