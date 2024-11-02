package io.backend.tech.concurrency.thread.demo.seven;

public class Printer implements Runnable {

	@Override
	public void run() {
		try {
			System.out.println("Hello from Printer");
			Thread.sleep(50000);
		}
		catch(InterruptedException e) {
			System.err.println(Thread.currentThread().getName()+" is interrupted.");
		}
	}

}
