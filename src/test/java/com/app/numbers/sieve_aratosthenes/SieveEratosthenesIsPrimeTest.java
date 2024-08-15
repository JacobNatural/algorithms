package com.app.numbers.sieve_aratosthenes;

import com.app.extension.numbers.sieve_eratosthenes.SieveEratosthenesExtension;
import com.app.numbers.sieve_eratosthenes.SieveEratosthenes;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(SieveEratosthenesExtension.class)
@AllArgsConstructor
public class SieveEratosthenesIsPrimeTest {

    private final SieveEratosthenes sieveEratosthenes;

    @Test
    @DisplayName("When the prime number is negative")
    public void test1(){
        Assertions.assertThatThrownBy(() ->
                sieveEratosthenes.isPrime(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Prime number is negative");
    }

    @Test
    @DisplayName("When the number is to large")
    public void test2(){
        Assertions.assertThatThrownBy(() ->
                        sieveEratosthenes.isPrime(600))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number is too large");
    }

    @ParameterizedTest
    @DisplayName("When is a prime")
    @CsvSource({"7","23","79","97","113","167","257","331","479"})
    public void test3(int n){
        Assertions
                .assertThat(sieveEratosthenes.isPrime(n))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("When is not a prime")
    @CsvSource({"8","15","55","72","80","150","186","222","350","400","482"})
    public void test4(int n){
        Assertions
                .assertThat(sieveEratosthenes.isPrime(n))
                .isFalse();
    }
}
