package com.app.huffman;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Map;

public class HuffmanUnpackUnpackTest {


    @Test
    @DisplayName("When binary code is null")
    public void test1(){

        HuffmanUnpack huffmanUnpack = new HuffmanUnpack(Map.of('a', "01"));

        Assertions
                .assertThatThrownBy(
                        () -> huffmanUnpack.unpack(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Binary code is null");
    }

    @Test
    @DisplayName("When binary code is empty")
    public void test2(){

        HuffmanUnpack huffmanUnpack = new HuffmanUnpack(Map.of('a', "01"));

        Assertions
                .assertThatThrownBy(
                        () -> huffmanUnpack.unpack(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Binary code is empty");
    }

    @Test
    @DisplayName("When binary code is invalid")
    public void test3(){

        HuffmanUnpack huffmanUnpack = new HuffmanUnpack(Map.of('a', "01"));

        Assertions
                .assertThatThrownBy(
                        () -> huffmanUnpack.unpack("13242"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid binary code");
    }

    @ParameterizedTest
    @MethodSource("com.app.huffman.HuffmanDataProvider#provideHuffmanData")
    public void test44(HuffmanDataModel huffmanDataModel){

        var binaryCode = String.join("", huffmanDataModel.data().keySet());
        HuffmanUnpack huffmanUnpack = HuffmanUnpack.of(huffmanDataModel.data().get(binaryCode));

        Assertions.assertThat(huffmanUnpack.unpack(binaryCode))
               .isEqualTo(huffmanDataModel.text());
    }
}
