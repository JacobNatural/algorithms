package com.app.huffman;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


@RequiredArgsConstructor
public class HuffmanPackPackTest {

    @ParameterizedTest
    @MethodSource("com.app.huffman.HuffmanDataProvider#provideHuffmanData")
    @DisplayName("Like pack correctly")
    public void test1(HuffmanDataModel huffmanDataModel){

        HuffmanPack huffmanPack = HuffmanPack.of(huffmanDataModel.text());

        Assertions.assertThat(huffmanPack.pack())
                .isEqualTo(huffmanDataModel.data());

    }
}