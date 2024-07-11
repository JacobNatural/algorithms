package com.app.numbers.position_systems;

import com.app.extension.numbers.position_systems.HexadecimalExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(HexadecimalExtension.class)
@RequiredArgsConstructor
public class HexadecimalChangeToDecimalTest {

    private final Hexadecimal hexadecimal;

    @Test
    @DisplayName("When hexadecimal is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> hexadecimal.changeToDecimal(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hexadecimal is null");
    }

    @Test
    @DisplayName("When hexadecimal is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> hexadecimal.changeToDecimal(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hexadecimal is empty");
    }

    @Test
    @DisplayName("When hexadecimal is invalid")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> hexadecimal.changeToDecimal("2110ZB"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hexadecimal is invalid");
    }

    @ParameterizedTest
    @DisplayName("When hexadecimal change correctly")
    @CsvFileSource(resources = "/numbers/position_systems/hexadecimal.csv")
    public void test4(String hex, int expectedDecimal){
        Assertions.assertThat(hexadecimal.changeToDecimal(hex))
                .isEqualTo(expectedDecimal);
    }
}
