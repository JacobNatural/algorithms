package com.app.huffman;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HuffmanPackHuffmanOfTest {

    @Test
    @DisplayName("When text is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> HuffmanPack.of(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");
    }

    @Test
    @DisplayName("When text is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(() -> HuffmanPack.of(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");
    }

    @Test
    @DisplayName("When text not thrown exception")
    public void test3(){

        Assertions.assertThatNoException()
                .isThrownBy(() -> HuffmanPack.of("text"));
    }
}
