package io.backend.tech.concurrency.thread.demo.ten;

public class Producer implements Runnable{

	private NotificationMessage notificationMessage;
	
	public Producer(NotificationMessage notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	@Override
	public void run() {
		System.out.println("Notification Produced");
		notificationMessage.notify();
		/*
		 * synchronized (Object.class) { System.out.println("Notification Produced");
		 * notificationMessage.notify(); }
		 */
	}
}
