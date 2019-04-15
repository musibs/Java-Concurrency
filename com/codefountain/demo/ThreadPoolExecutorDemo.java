package com.deofountain.concurrency.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {


    
	public static void main(String[] args) {
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 2000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1));
		threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
		threadPoolExecutor.execute(() -> {
			try {
				Thread.sleep(500000);
			}
			catch(InterruptedException ie) {
				//
			}
		});
		
		threadPoolExecutor.execute(() -> {
			try {
				Thread.sleep(500000);
			}
			catch(InterruptedException ie) {
				//
			}
		});
		
		threadPoolExecutor.execute(() -> {
			try {
				Thread.sleep(500000);
			}
			catch(InterruptedException ie) {
				//
			}
		});
		
		
	}
}
