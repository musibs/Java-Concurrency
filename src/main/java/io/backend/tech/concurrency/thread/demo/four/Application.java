package io.backend.tech.concurrency.thread.demo.four;

public class Application {

	public static void main(String[] args) {
		Incrementer incrementer = new Incrementer();
		Thread thread1 = new Thread(incrementer);
		thread1.start();
		
		Thread thread2 = new Thread(incrementer);
		thread2.start();
	}
}
