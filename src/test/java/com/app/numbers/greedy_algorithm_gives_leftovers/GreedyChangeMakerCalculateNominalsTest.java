package com.app.numbers.greedy_algorithm_gives_leftovers;

import com.app.extension.numbers.greedy_algorithms_gives_leftovers.DenominationsExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@ExtendWith(DenominationsExtension.class)
@RequiredArgsConstructor
public class GreedyChangeMakerCalculateNominalsTest {

    private final GreedyChangeMaker greedyChangeMaker;

    @ParameterizedTest
    @DisplayName("When payment is invalid")
    @CsvSource({"0,-2"})
    public void test1(int payment) {
        Assertions
                .assertThatThrownBy(
                        () -> greedyChangeMaker.calculateNominals(payment, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Payment is negative or null");
    }

    @ParameterizedTest
    @DisplayName("When price is invalid")
    @CsvSource({"0,-3"})
    public void test2(int price) {
        Assertions
                .assertThatThrownBy(
                        () -> greedyChangeMaker.calculateNominals(1, price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Price is negative or null");
    }

    @Test
    @DisplayName("Price is higher than payment")
    public void test3() {
        Assertions
                .assertThatThrownBy(
                        () -> greedyChangeMaker.calculateNominals(10, 30))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Payment is less than price");
    }

    @Test
    @DisplayName("When we don't have necessary nominals")
    public void test4() {
        Assertions
                .assertThatThrownBy(
                        () -> greedyChangeMaker.calculateNominals(1233, 31)
                )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Not possible to calculate nominals");
    }

    static Stream<Arguments> nominalsProvider() {
        return Stream.of(
                Arguments.of(200, 100, List.of(100)),
                Arguments.of(550, 130, List.of(200, 200, 20)),
                Arguments.of(1050, 125, List.of(500, 200, 200, 20, 5)),
                Arguments.of(1350, 75, List.of(500, 500, 200, 50, 20, 5))
        );
    }

    @ParameterizedTest
    @DisplayName("When we calculate exceptedNominals")
    @MethodSource("nominalsProvider")
    public void test5(int payment, int price, List<Integer> exceptedNominals) {
        Assertions
                .assertThat(greedyChangeMaker.calculateNominals(payment, price))
                .isEqualTo(exceptedNominals);
    }
}
