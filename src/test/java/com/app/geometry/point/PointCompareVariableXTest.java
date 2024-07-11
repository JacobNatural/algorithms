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
public class PointCompareVariableXTest {

    private final Point point;

    @Test
    @DisplayName("When point is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> point.compareVariableX(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Point is null");
    }

    @ParameterizedTest
    @CsvSource({"2.0,5.3","1.5,6.0","0.7,7.0"})
    @DisplayName("When compare is true")
    public void test2(double x, double y){
        Assertions
                .assertThat(point.compareVariableX(new Point(x,y)))
                .isTrue();
    }

    @ParameterizedTest
    @CsvSource({"6.0,5.3","4.5,6.0","9.7,7.0"})
    @DisplayName("When compare is false")
    public void test3(double x, double y){
        Assertions
                .assertThat(point.compareVariableX(new Point(x,y)))
                .isFalse();
    }

}
