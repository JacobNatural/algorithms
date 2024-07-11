package com.app.numbers.utility.recursion;

import com.app.numbers.utility.iteration.NumberUtilityIteration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumberUtilityRecursionGetMinTest {

    @Test
    @DisplayName("When array is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> NumberUtilityRecursion.getMin(null)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Array is null");
    }

    @Test
    @DisplayName("When array is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> NumberUtilityRecursion.getMin(new int[]{})
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Array is empty");
    }

    static Stream<Arguments> dataProvider(){
        return Stream.of(
                Arguments.of(5,new int[]{8,5,10}),
                Arguments.of(1,new int[]{8,3,1,1,24,10}),
                Arguments.of(3,new int[]{8,3,4,18,5,10})
        );
    }

    @ParameterizedTest
    @DisplayName("When get min")
    @MethodSource("dataProvider")
    public void test3(int min, int[] array){
        Assertions
                .assertThat(NumberUtilityRecursion.getMin(array))
                .isEqualTo(min);
    }
}
