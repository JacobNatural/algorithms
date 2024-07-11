package com.app.numbers.polynomial;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

public class PolynomialOfTest {

    @Test
    @DisplayName("When coefficients are null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () ->Polynomial.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Coefficients are null");
    }

    @Test
    @DisplayName("When coefficients are empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () ->Polynomial.of(new double[0]))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Coefficients are empty");
    }

    @Test
    @DisplayName("When start correctly")
    public void test3(){
        Assertions.assertThatNoException()
                .isThrownBy(() -> Polynomial.of(new double[]{3.5,2.3,1.0}));


    }
}
