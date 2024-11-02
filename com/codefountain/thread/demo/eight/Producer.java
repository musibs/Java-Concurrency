package com.codefountain.thread.demo.eight;

public class Producer implements Runnable{

	private Notification notificationMessage;
	
	public Producer(Notification notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	@Override
	public void run() {
		synchronized (notificationMessage) {
			System.out.println("Content produced.");
			notificationMessage.notify();
		}
	}

}
