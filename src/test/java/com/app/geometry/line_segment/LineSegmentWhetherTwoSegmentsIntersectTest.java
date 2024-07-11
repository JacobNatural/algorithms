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
public class LineSegmentWhetherTwoSegmentsIntersectTest {

    private final LineSegment lineSegment;

    @Test
    @DisplayName(("When line segment is null"))
    void test1(){
        Assertions
                .assertThatThrownBy(
                () -> lineSegment.whetherTwoSegmentsIntersect(null)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Line segment is null");
    }

    @ParameterizedTest
    @DisplayName("When two line segment are intersect")
    @CsvSource({"-3.0,3.0,3.0,-3.0","-2.0,5.0,4.0,-3.0","-4.0,0.0,-2.0,-1.0"})
    public void test2(double p1X, double p1Y, double p2X, double p2Y){

        Assertions
                .assertThat(
                        lineSegment.whetherTwoSegmentsIntersect(
                                new LineSegment(
                                        new Point(p1X, p1Y), new Point(p2X, p2Y))))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("When two line segment are not intersect")
    @CsvSource({"-3.0,3.0,-3.0,3.0","-2.3,5.0,-2.5,3.0","-6.0,2.0,-6.0,-1.0"})
    public void test3(double p1X, double p1Y, double p2X, double p2Y){

        Assertions
                .assertThat(
                        lineSegment.whetherTwoSegmentsIntersect(
                                new LineSegment(
                                        new Point(p1X, p1Y), new Point(p2X, p2Y))))
                .isFalse();
    }
}
