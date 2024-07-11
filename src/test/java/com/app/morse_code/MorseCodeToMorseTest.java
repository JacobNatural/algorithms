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
public class MorseCodeToMorseTest {

    private final MorseCode morseCode;

    @Test
    @DisplayName("When text is null")
    public void test1() {
        Assertions
                .assertThatThrownBy(
                        () -> morseCode.toMorse(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");
    }

    @Test
    @DisplayName("When text is empty")
    public void test2() {
        Assertions
                .assertThatThrownBy(
                        () -> morseCode.toMorse(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");
    }

    @ParameterizedTest
    @DisplayName("When text is invalid")
    @CsvSource({"letters","Lotto", "Mother!!", "Are u ?", "GOOD-BAD"})
    public void test3(String text) {
        Assertions
                .assertThatThrownBy(
                        () -> morseCode.toMorse(text)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is invalid");
    }

    @ParameterizedTest
    @DisplayName("When transform words for morse code")
    @CsvFileSource(resources = "/morse_code/words.csv")
    public void test4(String words, String morse){
        Assertions
                .assertThat(morseCode.toMorse(words))
                .isEqualTo(morse);
    }

    @ParameterizedTest
    @DisplayName("When transform sentences for morse code")
    @CsvFileSource(resources = "/morse_code/sentences.csv" )
    public void test5(String sentences, String morse){
        Assertions
                .assertThat(morseCode.toMorse(sentences))
                .isEqualTo(morse);
    }
}
