package io.backend.tech.concurrency.thread.demo.seven;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Printer());
		thread.start();
		thread.interrupt();
		System.out.println(thread.getName() +" is done.");
	}
}
