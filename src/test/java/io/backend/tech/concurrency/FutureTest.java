package io.backend.tech.concurrency;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import io.backend.tech.concurrency.future.FutureDemo;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class FutureTest {

    @Test
    void testAsyncSum() {
        assertThat(new FutureDemo().runAsyncSum()).isEqualTo(55);
    }

    @Test
    void testAsyncDivideByZero() {
        assertThatExceptionOfType(ExecutionException.class)
                .isThrownBy(new FutureDemo()::runAsyncDivideByZero)
                .withMessageContaining("/ by zero");
    }

    @Test
    void testDelayedTaskIsNotDone() throws ExecutionException {
        assertThat(new FutureDemo().callDelayedTask()).isNotDone();
    }

    @Test
    void testDelayedTaskIsCancelled() throws ExecutionException {
        Future<Integer> future = new FutureDemo().callDelayedTask();
        future.cancel(true);
        assertThat(future).isCancelled();
    }
}
