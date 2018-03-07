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

加了 maven antlr 插件手，先 mvn clean package 后就可以 idea 运行 junit 了

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