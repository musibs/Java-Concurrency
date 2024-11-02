package io.backend.tech.concurrency.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Example of {@link Callable} and {@link Future}
 * 
 * @author Somnath Musib
 *
 */
public class FutureMain {

	public static void main(String[] args) {
		
		ExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadExecutor(); 
			Future<Integer> future = executorService.submit(new FutureDemo());
			if(!future.isDone()) {
				System.out.println("|INFO| Task is still in progress.");
			}
			System.out.println("|INFO| Waiting for the computation done.");
			Integer returnValue = future.get();
			System.out.println("|INFO| Sum is "+returnValue);
		} 
		catch (InterruptedException | ExecutionException e) {
			System.err.println("|ERROR| Exception occured "+e.getMessage());
		}
		finally {
			System.out.println("|INFO| Shutting down the thread pool");
			executorService.shutdown();
		}
		
	}
	
	
	/**
	 * A {@link Callable} task to compute sum of 1 to 10.
	 * A delay is introduce to display how main thread waits 
	 * on blocking future.get() invocation
	 * 
	 * @author Somnath Musib
	 *
	 */
	static class FutureDemo implements Callable<Integer>{
		
		@Override
		public Integer call() throws Exception {
			int sum =0;
			System.out.println("|INFO| Computation is being done by "+Thread.currentThread().getName());
			for(int i=0; i<10;i++) {
				sum+=i;
				TimeUnit.SECONDS.sleep(1);
			}
			return sum;
		}
		
	}
}
