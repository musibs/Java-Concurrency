package io.backend.tech.concurrency.thread.demo.three;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello World from My Runnable");
		System.out.println("Thread name:" +Thread.currentThread().getName());
		System.out.println("Thread priority: "+Thread.currentThread().getPriority());
		System.out.println("Thread Id: "+Thread.currentThread().getId());
	}

}
