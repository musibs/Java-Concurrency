package io.backend.tech.concurrency.basics;

public class MyRunnable implements Runnable {

	public static void main(String[] args) {
		System.out.println("-----------Thread Information:-------- ");
		System.out.println("Thread Information: ");
		System.out.println("Thread Name: "+Thread.currentThread().getName());
		System.out.println("Thread Id: "+Thread.currentThread().getId());
		System.out.println("Thread State: "+Thread.currentThread().getState());
		System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
		System.out.println("-------------------------------------");
		Thread runnable = new Thread(new MyRunnable());
		runnable.start();
	}
	
	@Override
	public void run() {
		System.out.println("-----------Thread Information:-------- ");
		System.out.println("Thread Name: "+Thread.currentThread().getName());
		System.out.println("Thread Id: "+Thread.currentThread().getId());
		System.out.println("Thread State: "+Thread.currentThread().getState());
		System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
		System.out.println("-------------------------------------");

		for(int i=0; i<=5; i++) {
			System.out.println(i);
		}
	}
}
