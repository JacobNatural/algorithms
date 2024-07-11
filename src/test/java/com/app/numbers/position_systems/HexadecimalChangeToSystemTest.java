package com.app.numbers.position_systems;

import com.app.extension.numbers.position_systems.HexadecimalExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(HexadecimalExtension.class)
@RequiredArgsConstructor
public class HexadecimalChangeToSystemTest {

    private final Hexadecimal hexadecimal;

    @ParameterizedTest
    @DisplayName("When decimal number is invalid")
    @CsvSource({"-5","-1"})
    public void test1(int decimalNumber){
        Assertions
                .assertThatThrownBy(
                        () -> hexadecimal.changeToSystem(decimalNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Decimal number is negative");
    }

    @ParameterizedTest
    @DisplayName("When change correctly")
    @CsvFileSource(resources = "/numbers/position_systems/hexadecimal.csv")
    public void test2(String hex, int decimalNumber){
        Assertions
                .assertThat(hexadecimal.changeToSystem(decimalNumber))
                .isEqualTo(hex.toUpperCase());
    }

}
