package io.backend.tech.concurrency.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class ExecutorDemo {

	
	public static void main(String[] args) {
		
		Executor executor = Executors.newFixedThreadPool(2);
		executor.execute(() -> {
			Stream.of(1,2,3,4,5,6,7,8,9,10).forEach(System.out::println);;
		});		
	}
}
