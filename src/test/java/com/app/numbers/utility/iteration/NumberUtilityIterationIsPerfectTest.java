package com.app.numbers.utility.iteration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberUtilityIterationIsPerfectTest {

    @ParameterizedTest
    @DisplayName("When the number is invalid")
    @CsvSource({"-2","2","5"})
    public void test1(int number){
        Assertions
                .assertThat(NumberUtilityIteration.isPerfect(number))
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("When the number is perfect")
    @CsvSource({"6","28","496","8128"})
    public void test2(long number){
        Assertions
                .assertThat(NumberUtilityIteration.isPerfect(number))
                .isTrue();
    }
    @ParameterizedTest
    @DisplayName("When the number is not perfect")
    @CsvSource({"63","228","7","87"})
    public void test3(long number){
        Assertions
                .assertThat(NumberUtilityIteration.isPerfect(number))
                .isFalse();
    }

}
