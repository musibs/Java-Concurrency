package io.backend.tech.concurrency.threadpool.cached;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Example of cached thread pool
 * 
 * @author Somnath Musib
 *
 */
public class CachedThreadPoolMain {

	/**
	 * High number of short lived jobs
	 */
	private static final int NO_OF_JOBS = 200;
	
	public static void main(String[] args) {

		ExecutorService executorService = null;
		try {
			executorService = Executors.newCachedThreadPool();
			for(int i=0; i<NO_OF_JOBS; i++) {
				executorService.submit(new CallableTask(i));
			}
		}
		finally {
			executorService.shutdown();
		}
		
	}
	
	
	/**
	 * A {@link Callable} task
	 * 
	 * @author Somnath Musib
	 *
	 */
	static class CallableTask implements Callable<Void>{

		private final int taskId;
		
		public int getTaskId() {
			return taskId;
		}
		
		public CallableTask(int taskId) {
			this.taskId = taskId;
		}
		@Override
		public Void call() throws Exception {
			System.out.println("Task number "+ taskId + " is execured by thread "+Thread.currentThread().getName());
			return null;
		}
		
		public String toString() {
			return "{Task Id "+ taskId +"}";
		}
	}

}
