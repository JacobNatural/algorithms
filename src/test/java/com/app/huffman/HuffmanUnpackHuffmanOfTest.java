package com.app.huffman;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class HuffmanUnpackHuffmanOfTest {

    @Test
    @DisplayName("When code map is null")
    public void test1() {
        Assertions
                .assertThatThrownBy(() -> HuffmanUnpack.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Code map is null");
    }

    @Test
    @DisplayName("When code map is empty")
    public void test2() {
        Assertions
                .assertThatThrownBy(() -> HuffmanUnpack.of(Map.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Code map is empty");
    }

    @Test
    @DisplayName("When not thrown the exception")
    public void test3() {

        Assertions.assertThatNoException()
                .isThrownBy(() -> HuffmanUnpack.of(Map.of('a', "01")) );

    }



}
