package com.app.geometry.point;


import com.app.extension.geometry.PointExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(PointExtension.class)
@RequiredArgsConstructor
public class PointProductVariableXTest {

    private final Point point;

    @ParameterizedTest
    @DisplayName("Calculate correct")
    @CsvSource({"4.0,14.0","2.0,7.0","5.5,19.25"})
    public void test2(double x, double expected){

        Assertions
                .assertThat(point.productVariableX(x))
                .isEqualTo(expected);
    }
}
