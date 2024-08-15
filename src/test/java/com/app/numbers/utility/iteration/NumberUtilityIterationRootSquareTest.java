package com.app.numbers.utility.iteration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberUtilityIterationRootSquareTest {

    @ParameterizedTest
    @DisplayName("When the number is invalid")
    @CsvSource({"-5","-1","0"})
    public void test1(double number){
        Assertions
                .assertThatThrownBy(
                        () -> NumberUtilityIteration.squareRoot(number, 0.1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number is invalid");
    }

    @ParameterizedTest
    @DisplayName("When the epsilon is invalid")
    @CsvSource({"-1.0","0.0","1.0","2.0"})
    public void test2(double epsilon){
        Assertions
                .assertThatThrownBy(
                        () -> NumberUtilityIteration.squareRoot(3,epsilon)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Epsilon is invalid");
    }

    @ParameterizedTest
    @DisplayName("When the calculate correctly with the same epsilon")
    @CsvFileSource(resources = "/numbers/utility/root_square_numbers.csv")
    public void test3(int number, double expected){
        Assertions.assertThat(NumberUtilityIteration.squareRoot(number,0.00001))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("When the calculate correctly with different epsilon")
    @CsvFileSource(resources = "/numbers/utility/root_square_epsilon.csv")
    public void test4(double epsilon, double expected){
        Assertions.assertThat(NumberUtilityIteration.squareRoot(300,epsilon))
                .isEqualTo(expected);
    }
}
