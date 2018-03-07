## antlr4

antlr4 源码目录，如

```
├── src
│   ├── main
│   │   ├── antlr4
│   │   │   └── com.chenlb.study_trails.antlr4
│   │   │       ├── ArrayInit.g4
│   │   │       └── Hello.g4
│   │   ├── java
│   │   └── resources
│   └── test
│       └── java
│           └── com
│               └── chenlb
│                   └── study_trails
│                       └── antlr4
│                           └── ArrayInitTest.java
```

加了 maven antlr 插件手，先 ```mvn antlr4:antlr4``` 后就可以 idea 运行 junit 了

```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.antlr</groupId>
			<artifactId>antlr4-maven-plugin</artifactId>
			<version>4.7</version>
			<executions>
				<execution>
					<id>antlr</id>
					<goals>
						<goal>antlr4</goal>
					</goals>
				</execution>
			</executions>
		</plugin>
	</plugins>
</build>
```

可以在 maven 属性里是否开启 antlr4.visitor

```xml
<properties>
	<antlr4.visitor>true</antlr4.visitor>
</properties>
```

## SqlSplit.g4

实现 sql 分割的示例。在一大批以 ';' 分隔的 sql 文件 中。分割出一个个 sql。