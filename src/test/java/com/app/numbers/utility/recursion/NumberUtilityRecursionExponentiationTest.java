package com.app.numbers.utility.recursion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class NumberUtilityRecursionExponentiationTest {

    @Test
    @DisplayName("When exponent is negative")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                () -> NumberUtilityRecursion.exponentiation(2,-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Exponent is negative");
    }

    @ParameterizedTest
    @DisplayName("When calculate correctly")
    @CsvFileSource(resources = "/numbers/utility/exponentiation_numbers.csv")
    public void test2(long x, int exponent, int expectNumber){
        Assertions.assertThat(NumberUtilityRecursion.exponentiation(x,exponent))
                .isEqualTo(expectNumber);
    }
}
