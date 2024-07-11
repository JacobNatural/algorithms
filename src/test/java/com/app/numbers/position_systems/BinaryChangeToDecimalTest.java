package com.app.numbers.position_systems;

import com.app.extension.numbers.position_systems.BinaryExstension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(BinaryExstension.class)
@RequiredArgsConstructor
public class BinaryChangeToDecimalTest {

    private final Binary binary;

    @Test
    @DisplayName("When binary number is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> binary.changeToDecimal(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Binary number is null");
    }

    @Test
    @DisplayName("When binary number is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> binary.changeToDecimal(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Binary number is empty");
    }

    @Test
    @DisplayName("When binary number is invalid")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> binary.changeToDecimal("2110"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Binary number is invalid");
    }

    @ParameterizedTest
    @DisplayName("When change correctly")
    @CsvFileSource(resources = "/numbers/position_systems/binary_numbers.csv")
    public void test4(String binaryNumber, int expectedDecimal){

        Assertions
                .assertThat(binary.changeToDecimal(binaryNumber))
                .isEqualTo(expectedDecimal);
    }
}
