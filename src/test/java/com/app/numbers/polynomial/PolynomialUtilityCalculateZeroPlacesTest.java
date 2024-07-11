package com.app.numbers.polynomial;

import com.app.extension.numbers.polynomial.PolynomialUtilityExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(PolynomialUtilityExtension.class)
@RequiredArgsConstructor
public class PolynomialUtilityCalculateZeroPlacesTest {

    private final PolynomialUtility polynomialUtility;

    @ParameterizedTest
    @DisplayName("When epsilon is incorrect")
    @CsvSource({"-1.0","1.0","2.0"})
    public void test1(double epsilon){
        Assertions
                .assertThatThrownBy(
                        () -> polynomialUtility.calculateZeroPlaces(4,2,epsilon))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Epsilon is incorrect");
    }

    @ParameterizedTest
    @DisplayName("When function does not meet any assumptions")
    @CsvSource({"3.0,4.0,0.1","1.0,1.0,0.3","2.2,3.3,0.5"})
    public void test2(double x1, double x2,double epsilon){
        Assertions
                .assertThatThrownBy(
                        () -> polynomialUtility.calculateZeroPlaces(x1,x2,epsilon))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The function does not meet the assumptions");
    }

    @ParameterizedTest
    @DisplayName("When function does not meet any assumptions")
    @CsvSource({"-3.0,4.0,0.1,1.1015625","1.5,-5.0,0.3,0.0","-1.2,3.3,0.5,1.3312499999999998"})
    public void test3(double x1, double x2,double epsilon, double expected){
        Assertions
                .assertThat(polynomialUtility.calculateZeroPlaces(x1,x2,epsilon))
                .isEqualTo(expected);
    }



}


