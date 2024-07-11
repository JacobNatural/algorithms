package com.app.cipher.rsa_cipher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RsaCipherTest {
    public static RSACipher rsaCipher;

    @BeforeAll
    public static void setUpBeforeClass(){
        rsaCipher = RSACipher.of();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/rsa_cipher/words.csv")
    @DisplayName("Encrypt and decrypt words")
    public void test1(String word){

        var encrypted = rsaCipher.encrypt(word);

        Assertions.assertThat(rsaCipher.decrypt(encrypted))
                .isEqualTo(word);
    }

    @Test
    @DisplayName("When text is null encrypt")
    public void test2(){
        Assertions
                .assertThatThrownBy(() -> rsaCipher.encrypt(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");
    }

    @Test
    @DisplayName("When text is empty encrypt")
    public void test3(){
        Assertions
                .assertThatThrownBy(() -> rsaCipher.encrypt(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");
    }

    @Test
    @DisplayName("When text is null decrypt")
    public void test4(){
        Assertions
                .assertThatThrownBy(() -> rsaCipher.decrypt(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");
    }

    @Test
    @DisplayName("When text is empty decrypt")
    public void test5(){
        Assertions
                .assertThatThrownBy(() -> rsaCipher.decrypt(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/rsa_cipher/sentences.csv")
    @DisplayName("Encrypt and decrypt sentences")
    public void test6(String sentence){
        var encrypted = rsaCipher.encrypt(sentence);

        Assertions.assertThat(rsaCipher.decrypt(encrypted))
                .isEqualTo(sentence);
    }
}
