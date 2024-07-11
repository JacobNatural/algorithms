package com.app.numbers.fibo;

import com.app.extension.numbers.fibo.FibonacciRecursiveExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(FibonacciRecursiveExtension.class)
@RequiredArgsConstructor
public class FibonacciRecursiveValueTest {

    private final FibonacciRecursive fibonacciRecursive;

    @ParameterizedTest
    @DisplayName("When n is invalid")
    @CsvFileSource(resources = "/numbers/fib/invalidNumbers.csv")
    public void test1(int n){
        Assertions
                .assertThat(fibonacciRecursive.value(n))
                .isEqualTo(n);
    }

    @ParameterizedTest
    @DisplayName("When calculate correct")
    @CsvFileSource(resources = "/numbers/fib/correctNumbers.csv")
    public void test2(int n, int expectedValue){
        Assertions
                .assertThat(fibonacciRecursive.value(n))
                .isEqualTo(expectedValue);
    }
}
