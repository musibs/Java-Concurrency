package io.backend.tech.concurrency.threadpoolexecutor;

import io.backend.tech.concurrency.threadpool.base.AppThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

	private static final int CORE_POOL_SIZE = 1;
	private static final int MAX_POOL_SIZE = 2;
	private static final int KEEP_ALIVE_TIME = 10;
    
	public static void main(String[] args) throws InterruptedException {


		/** Create a new thread pool executor
		 *  The minimum number of threads is 1
		 *  The maximum number of threads is 2
		 *  Keep alive time for idle thread is 10 seconds
		 *  The backing queue implementation is an ArrayBlockingQueue with capacity 2
		 *  The custom thread factory AppThreadFactory is used
		 *  The RejectedExecutionHandler is CallerRunsPolicy
		 */
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE,
																		MAX_POOL_SIZE,
																		KEEP_ALIVE_TIME,
																		TimeUnit.SECONDS,
																		new ArrayBlockingQueue<>(1),
																		new AppThreadFactory("medium-demo"),
																		new ThreadPoolExecutor.CallerRunsPolicy()
																		);
		// Prints the executing thread's name - medium-demo-thread-1
		threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()+" executed this task"));


		// Make the thread sleep so that it is not available for processing
		threadPoolExecutor.execute(() -> {
			try {
				Thread.sleep(500000);
			}
			catch(InterruptedException ie) {
				//
			}
		});

		// Prints the executing thread's name - This task is queued.
		threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()+" executed this task"));

		TimeUnit.SECONDS.sleep(2);

		// Remaining capacity is 0 as there is a task already queues. Since the queue size is 1. The queue is now full.
		System.out.println("Remaining queue capacity: "+threadPoolExecutor.getQueue().remainingCapacity());

		/**
		 * 	A new thread is created and put to sleep. At this stage, the max thread pool limit is reached.
		 * 	No new threads can be created.
		 */
		threadPoolExecutor.execute(() -> {
			try {
				System.out.println(Thread.currentThread().getName() + " is created and going to sleep");
				Thread.sleep(500000);
			}
			catch (InterruptedException ie) {}
		});

		/**
		 *  This task is executed by the main thread due to CallerRunPolicy.
		 *  Since both the threads of the pool is occupied and the queue is also full,
		 *  based on the CallerRunPolicy, Main thread executed the new tasks.
		 */
		threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()+" thread executed this task"));
		threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()+" thread executed this task"));
		threadPoolExecutor.shutdownNow();
	}
}
