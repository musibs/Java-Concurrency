package com.codefountain.concurrency.threadpool;

import java.util.concurrent.Executor;

public class ExecutorMain {

	public static void main(String[] args) {
		Executor directExecutor = new DirectExecutor();
		directExecutor.execute(() -> {System.out.println("Executed in direct executor. Thread name "+Thread.currentThread().getName());});
		directExecutor.execute(() -> {System.out.println("Executed in direct executor. Thread name "+Thread.currentThread().getName());});
		
		
		Executor threadPerTaskExecutor = new ThreadPerTaskExecutor();
		threadPerTaskExecutor.execute(() -> {System.out.println("Executed in thread per task executor. Thread name" +Thread.currentThread().getName());});
		threadPerTaskExecutor.execute(() -> {System.out.println("Executed in thread per task executor. Thread name" +Thread.currentThread().getName());});
	}
	
	
	/**
	 * An executor that executes the task on current thread 
	 * 
	 * @author Somnath Musib
	 *
	 */
	static class DirectExecutor implements Executor{
		@Override
		public void execute(Runnable command) {
			command.run();
		}
	}
	
	/**
	 * An executor that runs each task in a new thread
	 */
	static class ThreadPerTaskExecutor implements Executor{
		@Override
		public void execute(Runnable command) {
			Thread t = new Thread(command);
			t.start();
		}
	}
}
