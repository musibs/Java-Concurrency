package com.codefountain.concurrency.threadpool.cached;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.codefountain.concurrency.threadpool.base.AppThreadFactory;
import com.codefountain.concurrency.threadpool.cached.CachedThreadPoolMain.CallableTask;

public class CachedThreadPoolWithCustomThreadFactory {

	/**
	 * High number of short lived jobs
	 */
	private static final int NO_OF_JOBS = 200;
	
	/**
	 * High number of short lived jobs
	 */
	private static final String CUSTOM_CACHED_POOL = "CustomCachedThreadPool";
	
	public static void main(String[] args) {
		
		ExecutorService executorService = null;
		try {
			executorService = Executors.newCachedThreadPool(new AppThreadFactory(CUSTOM_CACHED_POOL));
			for(int i=0; i<NO_OF_JOBS; i++) {
				executorService.submit(new CallableTask(i));
			}
		}
		finally {
			executorService.shutdown();
		}
		
	}
}
