package io.backend.tech.concurrency.threadpool.fixed;

import io.backend.tech.concurrency.threadpool.base.AppThreadFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * This is a fixed thread pool example with custom Thread factory 
 * implementation. A custom thread factory is often useful to 
 * customize the thread creation instead of using Java's default 
 * thread creation process
 * 
 * @author Somnath Musib
 *
 */
public class FixedThreadPoolWithCustomThreadFactory {

	private static final int POOL_SIZE = 10;
	private static final int NO_OF_JOBS = 20;
	private static final String CUSTOM_POOL_NAME = "AppThreadPool";
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE, new AppThreadFactory(CUSTOM_POOL_NAME));
		for(int i=0; i< NO_OF_JOBS; i++) {
			executorService.submit(new CallableTask(i, 200));
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
		private final long delay;
		
		public int getTaskId() {
			return taskId;
		}
		
		public CallableTask(int taskId, long delay) {
			this.taskId = taskId;
			this.delay =  delay;
		}
		@Override
		public Void call() throws Exception {
			System.out.println("Task number "+ taskId + " is execured by thread "+Thread.currentThread().getName());
			TimeUnit.MILLISECONDS.sleep(delay);
			return null;
		}
		
		public String toString() {
			return "{Task Id "+ taskId +"}";
		}
	}
}
