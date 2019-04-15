package com.codefountain.thread.demo.eight;

public class Application {

	public static void main(String[] args) {
		
		Notification notificationMessage = new Notification("New Notification");
		
		Thread consumer1 = new Thread(new Consumer(notificationMessage));
		consumer1.start();
		Thread consumer2 = new Thread(new Consumer(notificationMessage));
		consumer2.start();
		
		
		Thread producer = new Thread(new Producer(notificationMessage));
		producer.start();
	}
}
