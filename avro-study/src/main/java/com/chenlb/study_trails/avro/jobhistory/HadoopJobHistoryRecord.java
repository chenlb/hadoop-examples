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

package com.chenlb.study_trails.avro.jobhistory;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.hadoop.mapreduce.jobhistory.EventType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenlb 2018-04-15 17:01
 */
public class HadoopJobHistoryRecord {

	EventType eventType;
	Class recordClass;
	List<Object> jobHistoryRecords = new ArrayList<>();

	public HadoopJobHistoryRecord(EventType eventType, Class recordClass) {
		this.eventType = eventType;
		this.recordClass = recordClass;
	}

	public void addRecord(Object record) {
		jobHistoryRecords.add(record);
	}

	public List<Object> getRecores() {
		return jobHistoryRecords;
	}

	public Class getRecordClass() {
		return recordClass;
	}
}
