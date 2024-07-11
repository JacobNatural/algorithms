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
public class PolynomialUtilityTrapezoidalTest {

    private final PolynomialUtility polynomialUtility;

    @ParameterizedTest
    @DisplayName("When a is higher than b")
    @CsvSource({"5.0,5.0,10","6.0,2.0,2"})
    public void test1(double a, double b, int n){
        Assertions
                .assertThatThrownBy(
                        () -> polynomialUtility.trapezoidal(a,b,n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("A is higher or equal to b");
    }

    @ParameterizedTest
    @DisplayName("When n is too low")
    @CsvSource({"2.0,5.0,0","1.0,2.0,-4"})
    public void test2(double a, double b, int n){
        Assertions
                .assertThatThrownBy(
                        () -> polynomialUtility.trapezoidal(a,b,n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("N is less than one");
    }

    @ParameterizedTest
    @DisplayName("When calculate correctly")
    @CsvSource({"2.0,5.0,4,454.0078125","1.0,2.0,6,6.353009259259258","1.0,2.0,2,6.84375"})
    public void test3(double a, double b, int n, double expected){
        Assertions
                .assertThat(polynomialUtility.trapezoidal(a,b,n))
                .isEqualTo(expected);
    }


}
