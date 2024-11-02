package com.codefountain.thread.demo.two;

public class MyThread extends Thread{

	public void run() {
		System.out.println("Hello World from My Thread");
		System.out.println("Thread name:" +Thread.currentThread().getName());
		System.out.println("Thread priority: "+Thread.currentThread().getPriority());
		System.out.println("Thread Id: "+Thread.currentThread().getId());
	}
}
