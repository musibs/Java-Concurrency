package com.codefountain.concurrency.threadpool.base;


/**
 * This is a more specialized thread to customize the thread
 * name
 *
 * @author Somnath Musib
 *
 */
public class AppThread extends Thread{

	private static final String POOL_DELIMITER = "-"; 
	
	
	/**
	 * Application thread
	 * 
	 * @param runnable, tasks to be processed
	 * @param pool, name of the pool
	 * @param id, Identifier for the thread
	 */
	public AppThread(ThreadGroup group, Runnable runnable, String pool, int id) {
		super(group, runnable, String.format("%s%s%d",pool, POOL_DELIMITER, id));
	}
}
