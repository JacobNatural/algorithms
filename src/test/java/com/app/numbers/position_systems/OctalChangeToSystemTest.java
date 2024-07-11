package com.app.numbers.position_systems;

import com.app.extension.numbers.position_systems.OctalExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(OctalExtension.class)
@RequiredArgsConstructor
public class OctalChangeToSystemTest {

    private final Octal octal;

    @ParameterizedTest
    @DisplayName("When the octal number is invalid")
    @CsvSource({"-5","-1"})
    public void test1(int decimalNumber){
        Assertions
                .assertThatThrownBy(
                        () -> octal.changeToSystem(decimalNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Octal number is negative");
    }

    @ParameterizedTest
    @DisplayName("When change correctly")
    @CsvFileSource(resources = "/numbers/position_systems/octal_numbers.csv")
    public void test2(String binaryNumber, int decimalNumber){
        Assertions
                .assertThat(octal.changeToSystem(decimalNumber))
                .isEqualTo(binaryNumber);
    }
}
