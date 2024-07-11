package com.app.cipher.caeser_cipher;

import com.app.cipher.caesar_cipher.CaesarCipher;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


public class CeaserCipherEncryptTest {


    @Test
    @DisplayName("When text is null")
    void test1(){

        CaesarCipher cipher = new CaesarCipher(2);

        Assertions.assertThatThrownBy(
                () -> cipher.encrypt(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");

    }

    @Test
    @DisplayName("When text is empty")
    void test2(){

        CaesarCipher cipher = new CaesarCipher(2);

        Assertions.assertThatThrownBy(
                        () -> cipher.encrypt(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ceaser_Cipher/ceaser_data.csv")
    @DisplayName("When key is big and sentences")
    void test3(String text, String expectedTest, int key){

        CaesarCipher cipher = new CaesarCipher(key);

        Assertions
                .assertThat(cipher.encrypt(text))
                .isEqualTo(expectedTest);
    }
}
