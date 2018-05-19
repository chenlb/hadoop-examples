## hive sql 解释

### 输入输出表识别

使用，参考 com.chenlb.study_trails.hive_sql.LineageInfoTest.test_lineage

```java
LineageInfo lep = new LineageInfo();
LineageInfo.LineageResult result = lep.getLineageInfo(CharStreams.fromString(sqlString), UTF8));

//LineageInfo.LineageResult 类如下属性
//private TreeSet<String> inputTable = new TreeSet<String>();
//private TreeSet<String> outputTable = new TreeSet<String>();
```

## 项目使用

```bash
# antlr4 语法生成 java 解释类
# 会在 target/generated-sources/antlr4 生成代码，不用其它处理。
# 这句只是为了 idea 能不报错写代码
mvn antlr4:antlr4
```