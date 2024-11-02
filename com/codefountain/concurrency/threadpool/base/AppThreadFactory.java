package com.codefountain.concurrency.threadpool.base;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Custom thread factory to create a new thread 
 * and assigns a custom name to the threads
 * 
 * @author Somnath Musib
 *
 */
public class AppThreadFactory implements ThreadFactory{

	private String poolName;
	private ThreadGroup group;

	private AtomicInteger atomicInteger = new AtomicInteger();
	
	public AppThreadFactory(String poolName) {
		this.poolName = poolName;
		SecurityManager s = System.getSecurityManager();
		group = Objects.nonNull(s) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
	}
	
	@Override
	public Thread newThread(Runnable runnable) {
		Thread t = new AppThread(group, runnable, poolName, atomicInteger.incrementAndGet());
		if(t.isDaemon()) {
			t.setDaemon(false);
		}
		if(t.getPriority() != Thread.NORM_PRIORITY) {
			t.setPriority(Thread.NORM_PRIORITY);
		}
		return t;
	}

}
