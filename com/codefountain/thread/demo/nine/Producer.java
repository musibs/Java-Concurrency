package com.codefountain.thread.demo.nine;

public class Producer implements Runnable{
	
	private Notification notificationMessage;
	
	public Producer(Notification notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	@Override
	public void run() {
		synchronized (notificationMessage) {
			System.out.println("Nofitication Produced");
			notificationMessage.notifyAll();
		}
	}

}
