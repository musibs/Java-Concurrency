package io.backend.tech.concurrency.executorservice;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorServiceDemo2 {

    public static void main(String... args) throws InterruptedException {

        // Create a single thread executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Create a list of Callable
        List<Callable<Void>> callableList = IntStream.rangeClosed(1, 30)
                .mapToObj(ExecutorServiceDemo2::createTask)
                .collect(Collectors.toList());

        // Invoke all the Callables
        executorService.invokeAll(callableList);

        // Shutdown the ExecutorService
        executorService.shutdown();

        // Allow maximum 10 seconds to complete the tasks
        if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Pool did not shut down within the timeout.");
        } else {
            System.out.println("Pool shut down successfully.");
        }
    }

    private static Callable<Void> createTask(int i) {
        return () -> {
            System.out.println("Task "+i+" is completed");
            return null;
        };
    }
}
