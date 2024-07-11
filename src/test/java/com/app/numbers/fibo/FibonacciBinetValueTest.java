package com.app.numbers.fibo;

import com.app.extension.numbers.fibo.FibonacciBinetExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(FibonacciBinetExtension.class)
@RequiredArgsConstructor
public class FibonacciBinetValueTest {

    private final FibonacciBinet fibonacciBinet;

    @ParameterizedTest
    @DisplayName("When n is invalid")
    @CsvFileSource(resources = "/numbers/fib/invalidNumbers.csv")
    public void test1(int n){
        Assertions
                .assertThat(fibonacciBinet.value(n))
                .isEqualTo(n);
    }

    @ParameterizedTest
    @DisplayName("When calculate correct")
    @CsvFileSource(resources = "/numbers/fib/correctNumbers.csv")
    public void test2(int n, int expectedValue){
        Assertions
                .assertThat(fibonacciBinet.value(n))
                .isEqualTo(expectedValue);
    }
}
