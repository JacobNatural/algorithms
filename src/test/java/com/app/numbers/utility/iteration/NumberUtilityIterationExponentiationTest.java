package com.app.numbers.utility.iteration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class NumberUtilityIterationExponentiationTest {

    @Test
    @DisplayName("When the exponent is negative")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                () -> NumberUtilityIteration.exponentiation(2,-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Exponent is negative");
    }

    @ParameterizedTest
    @DisplayName("When the calculate correctly")
    @CsvFileSource(resources = "/numbers/utility/exponentiation_numbers.csv")
    public void test2(long x, int exponent, int expectNumber){
        Assertions.assertThat(NumberUtilityIteration.exponentiation(x,exponent))
                .isEqualTo(expectNumber);
    }
}
