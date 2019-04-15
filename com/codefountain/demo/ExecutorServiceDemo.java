package com.deofountain.concurrency.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Collection<Runner> jobs = Arrays.asList(new Runner(1),new Runner(2),new Runner(3),new Runner(4),new Runner(5),new Runner(6),new Runner(7),new Runner(8),new Runner(9),new Runner(10));
		
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		jobs.forEach(j -> executorService.submit(j));
		
		//invokeAll(jobs, executorService);
		//invokeAll(jobs, executorService, 2);
		//invokeAny(jobs, executorService);
		//executorService.shutdown();
		executorService.shutdownNow();
		if(executorService.isShutdown()) {
			System.out.println("Pool successfully shutdown");
		}
		
		if(executorService.isTerminated()) {
			System.out.println("All tasks completed successfully");
		}
	}



	protected static void invokeAny(Collection<Runner> jobs, ExecutorService executorService)
			throws InterruptedException, ExecutionException {
		int jobId = executorService.invokeAny(jobs);
		System.out.println(jobId+" is picked up");
		System.out.println("Main thread done");
	}



	protected static void invokeAll(Collection<Runner> jobs, ExecutorService executorService)
			throws InterruptedException {
		List<Future<Integer>> results = executorService.invokeAll(jobs);
		results.forEach(f -> {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
	}
	
	protected static void invokeAll(Collection<Runner> jobs, ExecutorService executorService, int period)
			throws InterruptedException {
		List<Future<Integer>> results = executorService.invokeAll(jobs, period, TimeUnit.SECONDS);
		results.forEach(f -> {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
	}
	
	
	static class Runner implements Callable<Integer>{

		private final int JOB_ID;
		
		public Runner(int jobId) {
			this.JOB_ID = jobId;
		}
		
		@Override
		public Integer call() {
			try {
				Thread.sleep(100000);
				int sum = 0;
				for(int i=0; i<10;i++) {
					sum += i;
				}
				System.out.println("Job"+JOB_ID+" has computed "+sum);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return JOB_ID;
		}
		
	}
}
