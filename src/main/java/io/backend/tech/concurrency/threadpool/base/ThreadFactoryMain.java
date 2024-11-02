package io.backend.tech.concurrency.threadpool.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadFactoryMain {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2, new AppThreadFactory("medium-demo"));
        executorService.execute(() -> {
            IntStream.rangeClosed(1,4).forEach((i) -> System.out.println("Executed by "+Thread.currentThread().getName()));
        });

    }
}
