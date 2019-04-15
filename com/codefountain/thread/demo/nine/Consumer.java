package com.codefountain.thread.demo.nine;

public class Consumer implements Runnable{
	
	private Notification notificationMessage;
	
	public Consumer(Notification notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	@Override
	public void run() {
		synchronized (notificationMessage) {
			try {
				notificationMessage.wait();
				System.out.println("Nofitication Consumed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
