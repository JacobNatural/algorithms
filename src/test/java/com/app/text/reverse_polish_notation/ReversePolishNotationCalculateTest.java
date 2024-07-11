package com.app.text.reverse_polish_notation;

import com.app.extension.text.reverse_polish_notation.ReversePolishNotationExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(ReversePolishNotationExtension.class)
@RequiredArgsConstructor
public class ReversePolishNotationCalculateTest {

    private final ReversePolishNotation reversePolishNotation;

    @Test
    @DisplayName("When reverse polish notation is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> reversePolishNotation.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Reverse polish notation is null");
    }

    @Test
    @DisplayName("When the reverse polish notation is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> reversePolishNotation.calculate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Reverse polish notation is empty");
    }

    @Test
    @DisplayName("When the reverse polish notation is invalid")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> reversePolishNotation.calculate("1 2 + 3, "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Reverse polish notation is invalid");
    }

    @Test
    @DisplayName("When the reverse polish notations is error between operands and numbers")
    public void test4(){
        Assertions
                .assertThatThrownBy(
                        () -> reversePolishNotation.calculate("2 3 4 * + 3 + 3 + +"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Error between numbers and operators");
    }

    @Test
    @DisplayName("When the reverse polish notations has too much numbers")
    public void test5(){
        Assertions
                .assertThatThrownBy(
                        () -> reversePolishNotation.calculate("2 3 4 5 * + 3 + 3 + "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Numbers is too much");
    }

    @Test
    @DisplayName("When the reverse polish has wrong operand")
    public void test6(){
        Assertions
                .assertThatThrownBy(
                        () -> reversePolishNotation.calculate("2 3 4 5 * + 3   3 "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Wrong operand");
    }

    @ParameterizedTest
    @DisplayName("When the reverse polish notations calculate correctly")
    @CsvFileSource(resources = "/text/reverse_polish_notation/reverse_polish_notation.csv")
    public void test7(String notation, double expected) {
        Assertions
                .assertThat(reversePolishNotation.calculate(notation))
                .isEqualTo(expected);
    }
}

