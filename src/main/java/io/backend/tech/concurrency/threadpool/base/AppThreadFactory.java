package io.backend.tech.concurrency.threadpool.base;

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
		group = Thread.currentThread().getThreadGroup();
	}
	
	@Override
	public Thread newThread(Runnable runnable) {
		Thread appThread = new AppThread(group, runnable, poolName, atomicInteger.incrementAndGet());
		if(appThread.isDaemon()) {
			appThread.setDaemon(false);
		}
		if(appThread.getPriority() != Thread.NORM_PRIORITY) {
			appThread.setPriority(Thread.NORM_PRIORITY);
		}
		return appThread;
	}

}
