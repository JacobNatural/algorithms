package com.app.text.utility;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TextUtilityIsPalindromeTest {

    @Test
    @DisplayName("When the palindrome is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.isPalindrome(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is null");
    }

    @Test
    @DisplayName("When the palindrome is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(() -> TextUtility.isPalindrome(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Text is empty");
    }

    @ParameterizedTest
    @DisplayName("When the text is not a palindrome")
    @CsvFileSource(resources = "/text/text_utility/palindrome_false.csv")
    public void test3(String text){
        Assertions
                .assertThat(TextUtility.isPalindrome(text))
                .isFalse();
    }


    @ParameterizedTest
    @DisplayName("When the text is a palindrome")
    @CsvFileSource(resources = "/text/text_utility/palindrome_true.csv")
    public void test4(String text){
        Assertions
                .assertThat(TextUtility.isPalindrome(text))
                .isTrue();
    }
}
