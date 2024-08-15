package com.app.text.utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TextUtilityIsPatternTest {

    @Test
    @DisplayName("When the test is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.hasPattern(null, "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");
    }

    @Test
    @DisplayName("When the pattern is null")
    public void test2(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.hasPattern("abc", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Pattern is null");
    }

    @Test
    @DisplayName("When the text is empty")
    public void test3(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.hasPattern("", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");
    }

    @Test
    @DisplayName("When the pattern is empty")
    public void test4(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.hasPattern("abc", ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Pattern is empty");
    }

    @ParameterizedTest
    @DisplayName("When is not a pattern")
    @CsvFileSource(resources = "/text/text_utility/pattern_false.csv")
    public void test5(String txt, String pattern){
        Assertions
                .assertThat(TextUtility.hasPattern(txt, pattern))
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("When is a pattern")
    @CsvFileSource(resources = "/text/text_utility/pattern_true.csv")
    public void test6(String txt, String pattern){
        Assertions
                .assertThat(TextUtility.hasPattern(txt, pattern))
                .isTrue();
    }
}
