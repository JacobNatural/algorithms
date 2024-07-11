package com.app.geometry.line_function;

import com.app.extension.geometry.LineFunctionExtension;
import com.app.geometry.point.Point;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(LineFunctionExtension.class)
@RequiredArgsConstructor
public class LineFunctionIsPointOnLineFunctionTest {

    private final LineFunction lineFunction;

    @Test
    @DisplayName("When point is null")
    public void test1() {
        Assertions
                .assertThatThrownBy(
                        () -> lineFunction.isPointOnLineFunction(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point is null");
    }

    @ParameterizedTest
    @DisplayName("When point is on line function")
    @CsvSource({"-2.0,-2.0", "3.0,3.0", "0.0,0.0"})
    public void test2(double x, double y) {
        Assertions
                .assertThat(
                        lineFunction.isPointOnLineFunction(new Point(x, y)))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("When point is not on line function")
    @CsvSource({"-1.5,-2.0", "3.3,4.5", "0.5,1.5"})
    public void test3(double x, double y) {
        Assertions
                .assertThat(
                        lineFunction.isPointOnLineFunction(new Point(x, y)))
                .isFalse();
    }

}
