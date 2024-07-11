package com.app.numbers.polynomial;

import com.app.extension.numbers.polynomial.PolynomialUtilityExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(PolynomialUtilityExtension.class)
@RequiredArgsConstructor
public class PolynomialUtilityRectangleTest {

    private final PolynomialUtility polynomialUtility;

    @ParameterizedTest
    @DisplayName("When a is higher than b")
    @CsvSource({"5.0,5.0,10","6.0,2.0,2"})
    public void test1(double a, double b, int n){
        Assertions
                .assertThatThrownBy(
                        () -> polynomialUtility.rectangle(a,b,n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("A is higher or equal to b");
    }

    @ParameterizedTest
    @DisplayName("When n is too low")
    @CsvSource({"2.0,5.0,0","1.0,2.0,-4"})
    public void test2(double a, double b, int n){
        Assertions
                .assertThatThrownBy(
                        () -> polynomialUtility.rectangle(a,b,n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("N is less than one");
    }

    @ParameterizedTest
    @DisplayName("When calculate correctly")
    @CsvSource({"2.0,5.0,4,439.55859375","1.0,2.0,6,6.260995370370374","1.0,2.0,2,6.015625"})
    public void test3(double a, double b, int n, double expected){
        Assertions
                .assertThat(polynomialUtility.rectangle(a,b,n))
                .isEqualTo(expected);
    }
}
