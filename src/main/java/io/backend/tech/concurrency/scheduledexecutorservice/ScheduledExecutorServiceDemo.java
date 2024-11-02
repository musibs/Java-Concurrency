package io.backend.tech.concurrency.scheduledexecutorservice;

import java.time.LocalTime;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(() -> System.out.println("Executed by "+Thread.currentThread().getName()), 1, TimeUnit.SECONDS);

        ScheduledFuture<Integer> callableSum = scheduledExecutorService.schedule(() -> {
            return IntStream.rangeClosed(1,10).sum();
        }, 10, TimeUnit.SECONDS);

        System.out.println("Execution to callableSum is "+(callableSum.isDone() ? "done" : "not done ") +"and has delay of "+callableSum.getDelay(TimeUnit.SECONDS) +" seconds.");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Execution to callableSum is "+(callableSum.isDone() ? "done" : "not done ") +"and has delay of "+callableSum.getDelay(TimeUnit.SECONDS) +" seconds.");
        int result = callableSum.get();
        System.out.println("Execution to callableSum is "+(callableSum.isDone() ? "done " : "not done ") +"and result is "+result);

        //scheduledExecutorService.shutdown();

        //scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("Executing at "+ LocalTime.now()), 0, 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("Executing at "+ LocalTime.now());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 0, 3, TimeUnit.SECONDS);

    }
}
