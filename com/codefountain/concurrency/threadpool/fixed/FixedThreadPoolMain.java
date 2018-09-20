package com.codefountain.concurrency.threadpool.fixed;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Example of Fixed thread pool with normal and immediate shutdown.
 * 
 * @author Somnath Musib
 *
 */
public class FixedThreadPoolMain {
	
	private static final int THREAD_POOL_SIZE = 10;
	private static final int NO_OF_JOBS = 50;
	
	public static void main(String[] args) {
		FixedThreadPoolMain driver = new FixedThreadPoolMain();
		driver.fixedThreadPoolWithNormalShutdown();
		driver.fixedThreadPoolWithAwaitTermination();
		driver.fixedThreadPoolWithImmediateShutdown();
	}
	
	/**
	 * Fixed thread pool with normal shutdown
	 */
	protected void fixedThreadPoolWithNormalShutdown() {
		ExecutorService executorService = null;
		try{
			executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
			for(int i=0; i<NO_OF_JOBS; i++) {
				executorService.submit(new CallableTask(i+1, 200));
			}
		}
		finally {
			executorService.shutdown();
		}
	}
	
	/**
	 * Fixed thread pool with await termination. In this case, pool will be prevented
	 * from shutting down until all tasks are done or the timeout occurs based on
	 * whichever happens first. 
	 * 
	 * As per shutdown() documentation, it does not allow new tasks to be accepted, 
	 * however, it allows  existing tasks to be continue before the pool is finally
	 * shutdown. But there might be a time duration one would like to wait before
	 * forcefully shutdown the pool. Await termination is used to define a time interval
	 * before the pool is finally forcefully shuts down by canceling running tasks.
	 */
	protected void fixedThreadPoolWithAwaitTermination() {
		ExecutorService executorService = null;
		try{
			executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
			for(int i=0; i<NO_OF_JOBS; i++) {
				executorService.submit(new CallableTask(i+1, 10000));
			}
			executorService.shutdown();
			executorService.awaitTermination(5, TimeUnit.SECONDS);
			executorService.shutdownNow();
		}
		catch(Exception exception) {
			System.err.println("Exception occured "+exception.getMessage());
		}
	}
	
	/**
	 * Fixed thread pool with immediate shutdown
	 */
	protected void fixedThreadPoolWithImmediateShutdown() {
		ExecutorService executorService = null;
		try{
			executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
			for(int i=0; i<NO_OF_JOBS; i++) {
				executorService.submit(new CallableTask(i+1, 200));
			}
		}
		finally {
			List<Runnable> abandonedTasks = executorService.shutdownNow();
			System.out.println("Cancelled "+ abandonedTasks.size() +" tasks. List is "+abandonedTasks);
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
