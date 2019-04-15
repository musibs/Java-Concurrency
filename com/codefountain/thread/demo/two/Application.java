package com.codefountain.thread.demo.two;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello World from Main Thread");
		Thread thread = new MyThread();
		thread.run();
	}

}
