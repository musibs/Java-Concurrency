package com.codefountain.concurrency.basics;

/**
 * Creation of a new Thread bt extending {@link Thread} class
 * 
 * @author Somnath Musib
 *
 */
public class MyThread extends Thread{

	public static void main(String[] args) {
		System.out.println("-----------Thread Information:-------- ");
		System.out.println("Thread Information: ");
		System.out.println("Thread Name: "+Thread.currentThread().getName());
		System.out.println("Thread Id: "+Thread.currentThread().getId());
		System.out.println("Thread State: "+Thread.currentThread().getState());
		System.out.println("Thread Priority: "+Thread.currentThread().getPriority());
		System.out.println("-------------------------------------");
		Thread myThread = new MyThread();
		myThread.start();
	}
	
	
	/**
	 * Implementation of run()
	 */
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
