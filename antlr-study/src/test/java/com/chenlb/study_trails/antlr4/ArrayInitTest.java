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

package com.chenlb.study_trails.antlr4;import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author chenlinbin 2017-12-09 19:41
 */
public class ArrayInitTest {

	public static class ShortToUnicodeString extends ArrayInitBaseListener {

		private StringBuilder sb = new StringBuilder();

		@Override public void enterInit(ArrayInitParser.InitContext ctx) {
			sb.append('[');
		}

		@Override public void exitInit(ArrayInitParser.InitContext ctx) {
			sb.append(']');
		}

		@Override public void enterValue(ArrayInitParser.ValueContext ctx) {
			TerminalNode anInt = ctx.INT();
			if(anInt != null) {
				int value = Integer.valueOf(anInt.getText());
				sb.append("\\u00");
				sb.append(Integer.toHexString(value));
				sb.append(',');
			}

		}

		public String getResult() {
			return sb.toString();
		}
	}

	@Test
	public void test_run_AST() throws IOException {
		CharStream input = CharStreams.fromString("{99,{22,44},30}");

		ArrayInitLexer lexer = new ArrayInitLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ArrayInitParser parser = new ArrayInitParser(tokens);

		ParseTree tree = parser.init();

		//System.out.println(tree.toStringTree(parser));
		ParseTreeWalker walker = new ParseTreeWalker();

		ShortToUnicodeString toUnicodeString = new ShortToUnicodeString();
		walker.walk(toUnicodeString, tree);

		//System.out.println(toUnicodeString.getResult());
		Assert.assertEquals("[\\u0063,[\\u0016,\\u002c,]\\u001e,]", toUnicodeString.getResult());
	}
}
