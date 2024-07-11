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
public class PointProductVariableYTest {

    private final Point point;

    @ParameterizedTest
    @DisplayName("Calculate correct")
    @CsvSource({"4.0,22.0","2.0,11.0","5.5,30.25"})
    public void test1(double y, double expected){

        Assertions
                .assertThat(point.productVariableY(y))
                .isEqualTo(expected);
    }

}
