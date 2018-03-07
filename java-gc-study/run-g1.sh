#!/bin/sh

cd `pwd`
mkdir -p logs

JAVA_OPT="-Xms512m -Xmx512m -Xmn64m"
JAVA_OPT="$JAVA_OPT -Xloggc:./logs/gc-g1.log"
JAVA_OPT="$JAVA_OPT -verbose:gc -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps"
JAVA_OPT="$JAVA_OPT -XX:+PrintAdaptiveSizePolicy -XX:+PrintTenuringDistribution"
JAVA_OPT="$JAVA_OPT -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5 -XX:GCLogFileSize=1m"
JAVA_OPT="$JAVA_OPT -XX:MaxTenuringThreshold=1"
JAVA_OPT="$JAVA_OPT -XX:MaxGCPauseMillis=50"
JAVA_OPT="$JAVA_OPT -XX:ParallelGCThreads=8"
JAVA_OPT="$JAVA_OPT -XX:+UseG1GC -XX:InitiatingHeapOccupancyPercent=55 -XX:G1MixedGCCountTarget=8"
JAVA_OPT="$JAVA_OPT -XX:+UseCompressedOops -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./logs/java-g1.prof"
JAVA_OPT="$JAVA_OPT -XX:+UnlockCommercialFeatures -XX:+FlightRecorder"

echo $JAVA_OPT

java $JAVA_OPT -cp .:target/classes AllocMemFixedTime