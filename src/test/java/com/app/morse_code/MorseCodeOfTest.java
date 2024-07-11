package com.app.morse_code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MorseCodeOfTest {

    @Test
    @DisplayName("When filename is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> MorseCode.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is null");
    }

    @Test
    @DisplayName("When filename is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> MorseCode.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is empty");
    }

    @Test
    @DisplayName("When filename is invalid")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> MorseCode.of("aaa!"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Filename is invalid");
    }

    @Test
    @DisplayName("When file not exists")
    public void test4(){
        Assertions
                .assertThatThrownBy(
                        () -> MorseCode.of("aaaa.txt")
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("File not exist");
    }

    @Test
    @DisplayName("When file load and not throw the exception")
    public void test5(){
        Assertions.assertThatNoException()
                .isThrownBy(() -> MorseCode.of("src/main/resources/morse.txt"));
    }
}
