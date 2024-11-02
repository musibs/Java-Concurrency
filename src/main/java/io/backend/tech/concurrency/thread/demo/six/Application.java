package io.backend.tech.concurrency.thread.demo.six;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		
		/*
		 * synchronized (Application.class) { System.out.println("Before sleep");
		 * Thread.sleep(10000); System.out.println("After sleep");
		 * TimeUnit.SECONDS.sleep(10000); System.out.println("After another sleep"); }
		 */
		
		Thread thread1 = new Thread(new Printer("Hello from Thread1"));
		thread1.start();
		
		thread1.interrupt();
		System.out.println("Thread1 has finished");
	}
}
