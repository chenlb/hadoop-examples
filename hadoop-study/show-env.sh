#!/bin/sh

show_env() {
	echo "HADOOP_CONF_DIR=$HADOOP_CONF_DIR"
	echo "HADOOP_CLASSPATH=$HADOOP_CLASSPATH"
}

if [ $# -lt 1 ]
then
	show_env
else
	if [ "x$1" == "xlocal" ]
	then
		echo "export HADOOP_CONF_DIR=src/test/resources/local"
	fi

	if [ "x$1" == "xlocalhost" ]
	then
		echo "export HADOOP_CONF_DIR=src/test/resources/localhost"
	fi

	echo "export HADOOP_CLASSPATH=target/classes/"
fi
