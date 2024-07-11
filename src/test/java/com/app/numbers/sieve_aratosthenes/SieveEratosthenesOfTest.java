package com.app.numbers.sieve_aratosthenes;

import com.app.numbers.sieve_eratosthenes.SieveEratosthenes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
public class SieveEratosthenesOfTest {

    @ParameterizedTest
    @DisplayName("When number is too low")
    @CsvSource({"0","1","-5"})
    public void test1(int n){
        Assertions
                .assertThatThrownBy(
                        () -> SieveEratosthenes.of(n))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not available prime numbers till " + n);
    }

    @ParameterizedTest
    @DisplayName("When generate prime numbers and not throw exception")
    @CsvSource({"2","10","100","500"})
    public void test2(int n){
        Assertions.assertThatNoException()
                .isThrownBy(() -> SieveEratosthenes.of(n));
    }


}
