## 解释json

```java
ObjectMapper mapper = new ObjectMapper();
JsonNode root = mapper.readTree(InputStream);
```

## json path

```java
String json = "...";

List<String> authors = JsonPath.read(json, "$.store.book[*].author");
```

```xml
<dependency>
	<groupId>com.jayway.jsonpath</groupId>
	<artifactId>json-path</artifactId>
	<version>2.3.0</version>
</dependency>
```