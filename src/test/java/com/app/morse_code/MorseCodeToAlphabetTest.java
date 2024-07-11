package com.app.morse_code;

import com.app.extension.morse_code.MorseCodeExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(MorseCodeExtension.class)
@RequiredArgsConstructor
public class MorseCodeToAlphabetTest {

    private final MorseCode morseCode;

    @Test
    @DisplayName("When text is null")
    public void test1() {
        Assertions
                .assertThatThrownBy(
                        () -> morseCode.toAlphabet(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Morse is null");
    }

    @Test
    @DisplayName("When text is empty")
    public void test2() {
        Assertions
                .assertThatThrownBy(
                        () -> morseCode.toAlphabet(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Morse is empty");
    }

    @ParameterizedTest
    @DisplayName("When text is invalid")
    @CsvSource({"letters","Lotto", "Mother!!", "Are u ?", "GOOD-BAD"})
    public void test3(String text) {
        Assertions
                .assertThatThrownBy(
                        () -> morseCode.toAlphabet(text)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Morse is invalid");
    }

    @ParameterizedTest
    @DisplayName("When transform words for morse code")
    @CsvFileSource(resources = "/morse_code/words.csv")
    public void test4(String morse, String words){
        Assertions
                .assertThat(morseCode.toAlphabet(words))
                .isEqualTo(morse);
    }

    @ParameterizedTest
    @DisplayName("When transform sentences for morse code")
    @CsvFileSource(resources = "/morse_code/sentences.csv" )
    public void test5(String morse, String sentences){
        Assertions
                .assertThat(morseCode.toAlphabet(sentences))
                .isEqualTo(morse);
    }
}
