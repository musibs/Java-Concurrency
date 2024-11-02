package io.backend.tech.concurrency.threadpool.cached;

import io.backend.tech.concurrency.threadpool.base.AppThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CachedThreadPoolWithCustomThreadFactory {

	/**
	 * High number of short-lived jobs
	 */
	private static final int NO_OF_JOBS = 200;
	
	/**
	 * Custom thread pool name
	 */
	private static final String CUSTOM_CACHED_POOL = "CustomCachedThreadPool";
	
	public static void main(String[] args) {
		
		ExecutorService executorService = null;
		try {
			executorService = Executors.newCachedThreadPool(new AppThreadFactory(CUSTOM_CACHED_POOL));
			for(int i=0; i<NO_OF_JOBS; i++) {
				executorService.submit(new CachedThreadPoolMain.CallableTask(i));
			}
		}
		finally {
			executorService.shutdown();
		}
	}
}
