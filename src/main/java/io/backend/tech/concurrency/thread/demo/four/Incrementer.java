package io.backend.tech.concurrency.thread.demo.four;

public class Incrementer implements Runnable{

	private static int count = 1;
	
	@Override
	public void run() {
		doExecute();
	
	}
	
	public static void doExecute() {
		synchronized (Incrementer.class) {
			for(int i=0; i<100000; i++) {
				count++;
			}
			System.out.println(count);
		}
	}
	
}
