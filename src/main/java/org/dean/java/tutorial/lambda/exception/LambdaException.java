package org.dean.java.tutorial.lambda.exception;

import java.util.function.Consumer;

public final class LambdaException {

    @FunctionalInterface
    public interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;
    }

    @FunctionalInterface
    public interface ThrowingConsumerVoid<E extends Exception> {
        void accept() throws E;
    }

    public static <T> Consumer<T> consumerWrapper(
            ThrowingConsumer<T, Exception> throwingConsumer) {

        return i -> {
            try {
                throwingConsumer.accept(i);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    public static <T>Consumer<T> consumerWrapperVoid(
            ThrowingConsumerVoid<Exception> throwingConsumer) {

        return (i) -> {
            try {
                throwingConsumer.accept();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
