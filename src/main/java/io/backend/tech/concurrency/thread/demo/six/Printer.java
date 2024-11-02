package io.backend.tech.concurrency.thread.demo.six;

public class Printer implements Runnable {

	private String textToPrint;
	
	public Printer(String textToPrint) {
		this.textToPrint = textToPrint;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(50000);
			System.out.println(textToPrint);
		} catch (InterruptedException e) {
			System.err.println(Thread.currentThread().getName()+" is interrupted.");
		}
		
		
	}

}
