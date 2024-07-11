package com.app.geometry.point;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PointProductTest {

    @Test
    @DisplayName("When point is null")
    public void test1(){

        Point point = new Point(4.0,4.3);

        Assertions
                .assertThatThrownBy(() -> point.crossProduct(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point is null");
    }

    @ParameterizedTest
    @DisplayName("Calculate correct")
    @CsvSource({"2.5,3.5,0.0","2.0,3.5,-1.75","2.5,4.5,-2.5"})
    public void test2(double x, double y, double expectedCalculates){

        Point point = new Point(x,y);

        Assertions
                .assertThat(point.crossProduct(new Point(2.5,3.5)))
                .isEqualTo(expectedCalculates);
    }

}
