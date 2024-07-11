package com.app.numbers.position_systems;

import com.app.extension.numbers.position_systems.BinaryExstension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(BinaryExstension.class)
@RequiredArgsConstructor
public class BinaryChangeToSystemTest {

    private final Binary binary;

    @ParameterizedTest
    @DisplayName("When decimal number is invalid")
    @CsvSource({"-5","-1"})
    public void test1(int decimalNumber){
        Assertions
                .assertThatThrownBy(
                        () -> binary.changeToSystem(decimalNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Decimal number is negative");
    }

    @ParameterizedTest
    @DisplayName("When change correctly")
    @CsvFileSource(resources = "/numbers/position_systems/binary_numbers.csv")
    public void test2(String binaryNumber, int decimalNumber){
        Assertions
                .assertThat(binary.changeToSystem(decimalNumber))
                .isEqualTo(binaryNumber);
    }
}
