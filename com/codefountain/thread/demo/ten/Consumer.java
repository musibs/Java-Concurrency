package com.codefountain.thread.demo.ten;

public class Consumer implements Runnable{

	private NotificationMessage notificationMessage;
	
	public Consumer(NotificationMessage notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	@Override
	public void run() {
		synchronized (notificationMessage) {
			try {
				notificationMessage.wait();
				System.out.println("Notification Processed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
