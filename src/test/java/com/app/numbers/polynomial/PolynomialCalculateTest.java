package com.app.numbers.polynomial;

import com.app.extension.numbers.polynomial.PolynomialsExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

@ExtendWith(PolynomialsExtension.class)
@RequiredArgsConstructor
public class PolynomialCalculateTest {
    private final List<Polynomial> polynomials;

    @ParameterizedTest
    @DisplayName("Like calculate correctly for polynomial second degree")
    @CsvSource({"3.5,47.5","-2.0,9.0","5.5,106.5"})
    public void test1(double x, double expected) {

        Assertions.assertThat(
                polynomials.getFirst().calculate(x)
        )
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("Like calculate correctly for polynomial third degree")
    @CsvSource({"3.5,323.375","-2.0,-35.5","5.5,1136.375"})
    public void test2(double x, double expected) {

        Assertions.assertThat(
                        polynomials.get(1).calculate(x)
                )
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("Like calculate correctly for polynomial four degree")
    @CsvSource({"3.5,568.84375","-2.0,-25.5","5.5,3100.59375"})
    public void test3(double x, double expected) {

        Assertions.assertThat(
                        polynomials.get(2).calculate(x)
                )
                .isEqualTo(expected);
    }
}
