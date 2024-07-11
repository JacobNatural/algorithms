package com.app.huffman;

import com.app.extension.huffman.NodeExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(NodeExtension.class)
@RequiredArgsConstructor
public class NodeCheckNodeKeyTest {

    private final Node node;

    @Test
    @DisplayName("When node is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> node.checkNodeKey(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Node is null");
    }

    @ParameterizedTest
    @DisplayName("When compare nodes key is true")
    @CsvSource({"4,a","7,a","10,a"})
    public void test2(int key, char sign){
        Assertions.assertThat(node.checkNodeKey(new Node(key, sign)))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("When compare nodes key is false")
    @CsvSource({"1,a","3,a","-5,a"})
    public void test3(int key, char sign){
        Assertions.assertThat(node.checkNodeKey(new Node(key, sign)))
                .isFalse();
    }

}
