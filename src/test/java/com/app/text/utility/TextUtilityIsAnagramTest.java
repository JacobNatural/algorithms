package com.app.text.utility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TextUtilityIsAnagramTest {

    @Test
    @DisplayName("When the text 1 is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.isAnagram(null, "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text 1 is null");
    }

    @Test
    @DisplayName("When the text 2 is null")
    public void test2(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.isAnagram("abc", null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text 2 is null");
    }

    @Test
    @DisplayName("Whe then text 1 is empty")
    public void test3(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.isAnagram("", "abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text 1 is empty");
    }

    @Test
    @DisplayName("When the text 2 is empty")
    public void test4(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.isAnagram("abc", ""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text 2 is empty");
    }

    @ParameterizedTest
    @DisplayName("When the texts are not anagram")
    @CsvFileSource(resources = "/text/text_utility/anagram_false.csv")
    public void test5(String text1, String text2){
        Assertions
                .assertThat(TextUtility.isAnagram(text1, text2))
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("When the texts are anagram")
    @CsvFileSource(resources = "/text/text_utility/anagram_true.csv")
    public void test6(String text1, String text2){
        Assertions
                .assertThat(TextUtility.isAnagram(text1, text2))
                .isTrue();
    }
}
