## 命令号运行方式

```bash
#设置 classpath，这样直接可以使用类名运行，不用 jar
export HADOOP_CLASSPATH=target/classes/
```

### 使用 HADOOP_CONF_DIR 指定运行环境

通过 HADOOP_CONF_DIR 设置，不同的终端指定不同。

```bash
#本机运行。目录下 hadoop-local.xml 文件，指定本地单机运行 mapreduce。
export HADOOP_CONF_DIR=src/test/resources/local

#伪分布式
#export HADOOP_CONF_DIR=src/test/resources/localhost

hadoop com.chenlb.hadoop.examples.MaxTemperature example-resources/temperature output
```

### 使用 -conf 指定运行环境

要求 hadoop 程序实现 Tool，这样也方便写测试类，也能识别 - 参数，如 -fs -jt

```bash
#mvn compile

hadoop com.chenlb.hadoop.examples.MaxTemperatureDriver -conf src/test/resources/local/hadoop-local.xml example-resources/temperature output

#或 -fs -jt
#hadoop com.chenlb.hadoop.examples.MaxTemperatureDriver -fs file:/// -jt local example-resources/temperature output
```

### sh 脚本辅助设置运行环境

可以开多个终端来使用不同的运行环境，这样 hadoop 命令使用方式比较一致。

```bash
#查看运行环境
sh show-env.sh

#设置local
`sh show-env.sh local`

#设置伪分布式
`sh show-env.sh localhsot`
```