package com.app.numbers.utility.iteration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberUtilityIterationIsPrimeTest {


    @ParameterizedTest
    @DisplayName("When is a prime")
    @CsvSource({"2","43","53","131","151","523","599","1109","1163","1621"})
    public void test1(int number){
        Assertions
                .assertThat(NumberUtilityIteration.isPrime(number))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("When is not a prime")
    @CsvSource({"0","1","42","55","130","152","528","598","1110","1160","1628"})
    public void test2(int number){
        Assertions
                .assertThat(NumberUtilityIteration.isPrime(number))
                .isFalse();
    }
}
