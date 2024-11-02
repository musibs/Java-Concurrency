package io.backend.tech.concurrency.future;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class FutureDemo {

    private Callable<Integer> asyncSum = () -> IntStream.rangeClosed(1,10).sum();
    private Callable<Integer> asyncDivideByZero = () -> 1/0;
    private Callable<Integer> delayedTask  = () -> {
        TimeUnit.SECONDS.sleep(50);
        return 0;
    };

    public int runAsyncSum() {
        Future<Integer> asyncSumFuture = Executors.newSingleThreadExecutor().submit(asyncSum);
        int sum = 0;
        try {
           sum = asyncSumFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return sum;
    }

    public void runAsyncDivideByZero() throws ExecutionException {
        Future<Integer> asyncDivideByZeroFuture = Executors.newSingleThreadExecutor().submit(asyncDivideByZero);
        int sum = 0;
        try {
            asyncDivideByZeroFuture.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw e;
        }
    }

    public Future<Integer> callDelayedTask() throws ExecutionException {
        return Executors.newSingleThreadExecutor().submit(delayedTask);
    }
}
