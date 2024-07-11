package com.app.cipher.rsa_cipher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GeneratePrimeNumbersGenerateTest {

    @Test
    @DisplayName("When minimum prime number is too low")
    public void test1(){
        Assertions
                .assertThatThrownBy(() -> GeneratePrimeNumbers.generate(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Minimum max is 2");
    }

    @Test
    @DisplayName("When generate prime numbers till 100")
    public void test2(){

        var primeNumbers = List.of(
                2,3,5,7,11,13,17,19,23,29,
                31,37,41,43,47,53,59,61,
                67, 71,73,79,83,89,97);

        Assertions.assertThat(GeneratePrimeNumbers.generate(100))
                .isEqualTo(primeNumbers);
    }
}
