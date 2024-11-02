package io.backend.tech.concurrency.thread.demo.five;

public class Incrementer implements Runnable {

	private static int count = 1;
	
	@Override
	public void run() {
		doRun();
	}
	
	private static void doRun() {
		synchronized (Incrementer.class) {
			for(int i=0; i<100000; i++) {
				count++;
			}
			System.out.println(count);
		}
	}
	
}
