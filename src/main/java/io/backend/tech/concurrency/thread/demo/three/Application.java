package io.backend.tech.concurrency.thread.demo.three;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello World from main Thread");
		System.out.println("Thread Id: "+Thread.currentThread().getId());
		Thread thread = new Thread(new MyRunnable());
		thread.start();
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello World from Runnable inner class");
				System.out.println("Thread name:" +Thread.currentThread().getName());
				System.out.println("Thread priority: "+Thread.currentThread().getPriority());
				System.out.println("Thread Id: "+Thread.currentThread().getId());
				
			}
		});
		
		thread2.start();
		
		Thread thread3 = new Thread(() ->  {
			System.out.println("Hello World from Runnable lambda expression");
			System.out.println("Thread name:" +Thread.currentThread().getName());
			System.out.println("Thread priority: "+Thread.currentThread().getPriority());
			System.out.println("Thread Id: "+Thread.currentThread().getId());
		});
		
		thread3.start();
	}

}
