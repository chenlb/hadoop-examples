#!/bin/sh

cd `pwd`
mkdir -p logs

JAVA_OPT="-Xms512m -Xmx512m -Xmn64m"
JAVA_OPT="$JAVA_OPT -Xloggc:./logs/gc-cms.log"
JAVA_OPT="$JAVA_OPT -verbosegc -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps"
JAVA_OPT="$JAVA_OPT -XX:+PrintAdaptiveSizePolicy -XX:+PrintTenuringDistribution"
JAVA_OPT="$JAVA_OPT -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=1m"
JAVA_OPT="$JAVA_OPT -XX:MaxTenuringThreshold=1"
JAVA_OPT="$JAVA_OPT -XX:ParallelGCThreads=8"
JAVA_OPT="$JAVA_OPT -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=65"
JAVA_OPT="$JAVA_OPT -XX:+UseCompressedOops -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./logs/java-cms.prof"
JAVA_OPT="$JAVA_OPT -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"

echo $JAVA_OPT

java $JAVA_OPT -cp .:target/classes AllocMemFixedTime