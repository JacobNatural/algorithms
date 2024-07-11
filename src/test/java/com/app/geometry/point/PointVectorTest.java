package com.app.geometry.point;

import com.app.extension.geometry.PointExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(PointExtension.class)
@RequiredArgsConstructor
public class PointVectorTest {

    private final Point point;

    @Test
    @DisplayName("When point is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> point.vector(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point is null");
    }

    @ParameterizedTest
    @DisplayName("When calculates correct")
    @CsvSource({"5.5,3.4,2.0,-2.1","2.0,2.0,-1.5,-3.5","1.7,4.5,-1.8,-1.0"})
    public void test2(double x, double y, double expectedX, double expectedY){

        Assertions.assertThat(point.vector(new Point(x, y)))
                .isEqualTo(new Point(expectedX, expectedY));
    }
}
