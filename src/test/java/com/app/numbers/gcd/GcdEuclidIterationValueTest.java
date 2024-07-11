package com.app.numbers.gcd;

import com.app.extension.numbers.gcd.GcdEculidItertationExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@ExtendWith(GcdEculidItertationExtension.class)
@RequiredArgsConstructor
public class GcdEuclidIterationValueTest {

    private final GcdEuclidIteration gcdEuclidIteration;

    @Test
    @DisplayName("When argument a is invalid")
    public void test1(){
        Assertions.assertThatThrownBy(() -> gcdEuclidIteration.value(-2,4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Argument a is negative");
    }

    @Test
    @DisplayName("When argument b is invalid")
    public void test2(){
        Assertions.assertThatThrownBy(() -> gcdEuclidIteration.value(4,-4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Argument b is negative");
    }

    @ParameterizedTest
    @DisplayName("When calculate correctly low numbers")
    @CsvFileSource(resources = "/numbers/gcd/lowNumbers.csv")
    public void test3(int a, int b, int expected) {
        Assertions
                .assertThat(gcdEuclidIteration.value(a,b))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("When calculate correctly high numbers")
    @CsvFileSource(resources = "/numbers/gcd/lowNumbers.csv")
    public void test4(int a, int b, int expected) {
        Assertions
                .assertThat(gcdEuclidIteration.value(a,b))
                .isEqualTo(expected);
    }


}
