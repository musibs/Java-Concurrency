package io.backend.tech.concurrency.thread.demo.eight;

public class Consumer implements Runnable {

	private Notification notificationMessage;

	public Consumer(Notification notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	@Override
	public void run() {
		System.out.println("Consumer Thread "+Thread.currentThread().getName());
		synchronized (notificationMessage) {
			try {
				notificationMessage.wait();
				System.out.println("Content consumed");
			} 
			catch (InterruptedException e) {
				System.err.println(Thread.currentThread().getName()+" is interrupted");			
			}
		}
	}
	
}
