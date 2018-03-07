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

package com.chenlb.study_trails.java_gc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author chenlb 2017-09-19 19:15
 */
public class AllocMemFixedTime {

	private static int shardSizeKB = 1024;

	public static void main(String[] args) {
		final LinkedBlockingQueue<byte[]> datas = new LinkedBlockingQueue<>();

		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

		service.scheduleAtFixedRate(new Runnable() {

			int totalCleanCount = 0;

			@Override
			public void run() {
				totalCleanCount++;
				int realCleanBlock = 0;
				int maxCleanBlock = datas.size() > 1000000 ? datas.size()/3 - 20000 : 100;
				for(int i=0; i<maxCleanBlock; i++) {
					byte[] a = datas.poll();
					if(a != null) {
						realCleanBlock++;
					}
				}
				System.out.printf("%d\t%d/%d\n", totalCleanCount, realCleanBlock, maxCleanBlock);
			}
		}, 5, 10, TimeUnit.SECONDS);

		while (true) {
			byte[] d = new byte[shardSizeKB];
			for(int i =0; i<1000; i++ ) {
				datas.add(d);
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				break;
			}
		}
		System.out.println("my out!");
	}
}
