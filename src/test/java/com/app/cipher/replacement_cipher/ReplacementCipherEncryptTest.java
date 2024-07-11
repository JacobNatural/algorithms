package com.app.cipher.replacement_cipher;

import com.app.extension.cipher.ReplacemntCipherExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(ReplacemntCipherExtension.class)
@RequiredArgsConstructor
public class ReplacementCipherEncryptTest {

    private final ReplacementCipher replacementCipher;

    @Test
    @DisplayName("When text is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> replacementCipher.encrypt(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");
    }

    @Test
    @DisplayName("When text is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(() -> replacementCipher.encrypt(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");
    }



    @ParameterizedTest
    @DisplayName("When replace words")
    @CsvFileSource(resources = "/replacement_cipher/words.csv")
    public void test3(String text, String expectedText){

        Assertions
                .assertThat(replacementCipher.encrypt(text))
                .isEqualTo(expectedText);
    }

    @ParameterizedTest
    @DisplayName("When replace sentences")
    @CsvFileSource(resources = "/replacement_cipher/sentences.csv")
    public void test4(String text, String expectedText){

        Assertions
                .assertThat(replacementCipher.encrypt(text))
                .isEqualTo(expectedText);
    }


}
