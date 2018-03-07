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

package com.chenlb.study_trails.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.json.JsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import com.jayway.jsonpath.spi.mapper.MappingProvider;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author chenlb 2018-03-03 17:28
 */
public class StudyJacksonTest {

	@Test
	public void testReadJson() throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		String file = "/json-d1.json";
		InputStream jsonStream = this.getClass().getResourceAsStream(file);
		JsonNode root = mapper.readTree(jsonStream);

		Assert.assertNotNull(file+" 测试类路径中找不到！", root);


		int[] ts = new int[]{3, 2, 2, 2, 4};
		//System.out.println(root);
		Assert.assertTrue(root.isArray());
		Iterator<JsonNode> vs = root.iterator();
		int i=0;
		while(vs.hasNext()) {
			JsonNode n = vs.next();
			JsonNode t = n.get("type");
			Assert.assertEquals(t.asInt(), ts[i++]);
		}
		Assert.assertEquals(i, ts.length);
	}

	@Test
	public void testJsonPath() throws IOException {
		String file = "/json-d1.json";
		InputStream jsonStream = this.getClass().getResourceAsStream(file);

		List<Integer> types = JsonPath.read(jsonStream, "$[*].type");

		Integer[] ts = new Integer[]{3, 2, 2, 2, 4};
		List<Integer> rts = Arrays.asList(ts);
		Assert.assertEquals(types, rts);

		// jackson
		Configuration.setDefaults(new Configuration.Defaults() {

			private final JsonProvider jsonProvider = new JacksonJsonProvider();
			private final MappingProvider mappingProvider = new JacksonMappingProvider();

			@Override
			public JsonProvider jsonProvider() {
				return jsonProvider;
			}

			@Override
			public MappingProvider mappingProvider() {
				return mappingProvider;
			}

			@Override
			public Set<Option> options() {
				return EnumSet.noneOf(Option.class);
			}
		});

		jsonStream = this.getClass().getResourceAsStream(file);
		types = JsonPath.read(jsonStream, "$[*].type");
		Assert.assertEquals(types, rts);
	}
}
