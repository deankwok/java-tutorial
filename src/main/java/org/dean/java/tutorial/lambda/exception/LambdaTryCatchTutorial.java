package org.dean.java.tutorial.lambda.exception;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.dean.java.tutorial.lambda.exception.LambdaException.consumerWrapper;

@Slf4j
public class LambdaTryCatchTutorial {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);

        integers.forEach(consumerWrapper(LambdaTryCatchTutorial::print));
    }

    public static void print(Integer number) throws IOException {

        if (number == 4) {
            throw new IOException("This is a custom exception.");
        }

        log.info("The current number is {}", number);
    }
}
