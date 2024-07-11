package com.app.numbers.greedy_algorithm_gives_leftovers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;


public class DenominationsOfTest {

    @Test
    @DisplayName("When set of denominations is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                () -> Denominations.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Available denominations is null");
    }

    @Test
    @DisplayName("When set of denominations is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> Denominations.of(Set.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Available denominations is empty");
    }

    @Test
    @DisplayName("When creat correctly")
    public void test3(){
        org.junit.jupiter.api.Assertions
                .assertDoesNotThrow(
                        () -> Denominations.of(Set.of(1,2,5)));
    }


}
