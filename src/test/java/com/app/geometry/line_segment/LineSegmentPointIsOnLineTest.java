package com.app.geometry.line_segment;

import com.app.extension.geometry.LineSegmentExtension;
import com.app.geometry.point.Point;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(LineSegmentExtension.class)
@RequiredArgsConstructor
public class LineSegmentPointIsOnLineTest {

    private final LineSegment lineSegment;

    @Test
    @DisplayName("When point is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> lineSegment.pointIsOnLine(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point is null");
    }

    @ParameterizedTest
    @DisplayName("When point is on line segment")
    @CsvSource({"-2.0,-2.0","1.0,1.0","2.0,2.0"})
    public void test2(double x, double y){
        Assertions
                .assertThat(
                        lineSegment.pointIsOnLine(new Point(x,y)))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("When point is not on line segment")
    @CsvSource({"-1.5,-2.0","1.0,3.3","-2.0,2.1"})
    public void test3(double x, double y){
        Assertions
                .assertThat(
                        lineSegment.pointIsOnLine(new Point(x,y)))
                .isFalse();
    }
}
