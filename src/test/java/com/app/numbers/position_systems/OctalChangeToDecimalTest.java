package com.app.numbers.position_systems;

import com.app.extension.numbers.position_systems.OctalExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(OctalExtension.class)
@RequiredArgsConstructor
public class OctalChangeToDecimalTest {

    private final Octal octal;

    @Test
    @DisplayName("When the octal number is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> octal.changeToDecimal(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Octal number is null");
    }

    @Test
    @DisplayName("When the octal number is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> octal.changeToDecimal(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Octal number is empty");
    }

    @Test
    @DisplayName("When the octal number is invalid")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> octal.changeToDecimal("21180"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Octal number is invalid");
    }

    @ParameterizedTest
    @DisplayName("When change correctly")
    @CsvFileSource(resources = "/numbers/position_systems/octal_numbers.csv")
    public void test4(String binaryNumber, int expectedDecimal){

        Assertions
                .assertThat(octal.changeToDecimal(binaryNumber))
                .isEqualTo(expectedDecimal);
    }
}
