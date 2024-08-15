package com.app.numbers.sort;

import com.app.extension.numbers.sort.BubbleSortExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.app.numbers.sort.SortDataProvider.*;
import java.util.Comparator;
import java.util.List;

@ExtendWith(BubbleSortExtension.class)
@RequiredArgsConstructor
public class BubbleSortTest {

    private final BubbleSort<Integer> bubbleSort;

    @Test
    @DisplayName("When the list is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> bubbleSort.sort(null, Comparator.naturalOrder()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List is null");
    }

    @Test
    @DisplayName("When the list is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> bubbleSort.sort(List.of(), Comparator.naturalOrder()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List is empty");
    }

    @Test
    @DisplayName("When the comparator is null")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> bubbleSort.sort(numbers, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Comparator is null");
    }

    @Test
    @DisplayName("When the sort ascending")
    public void test4(){
        Assertions
                .assertThat(
                        bubbleSort.sortNaturalOrder(numbers))
                .isEqualTo(numberAscending);
    }

    @Test
    @DisplayName("When the sort descending")
    public void test5(){
        Assertions
                .assertThat(
                        bubbleSort.sortReversOrder(numbers))
                .isEqualTo(numberDescending);
    }
}
