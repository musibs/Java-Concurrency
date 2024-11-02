package io.backend.tech.concurrency.thread.demo;

public class FirstProgram {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("Thread name:" +Thread.currentThread().getName());
		System.out.println("Thread priority: "+Thread.currentThread().getPriority());
		System.out.println("Thread Id: "+Thread.currentThread().getId());
	}
}
