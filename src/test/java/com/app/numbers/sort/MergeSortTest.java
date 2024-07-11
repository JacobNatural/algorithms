package com.app.numbers.sort;

import com.app.extension.numbers.sort.MergeSortExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.app.numbers.sort.SortDataProvider.*;
import java.util.Comparator;
import java.util.List;

@ExtendWith(MergeSortExtension.class)
@RequiredArgsConstructor
public class MergeSortTest {

    private final MergeSort<Integer> mergeSort;

    @Test
    @DisplayName("When the list is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> mergeSort.sort(null, Comparator.naturalOrder()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List is null");
    }

    @Test
    @DisplayName("When the list is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> mergeSort.sort(List.of(), Comparator.naturalOrder()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List is empty");
    }

    @Test
    @DisplayName("When the comparator is null")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> mergeSort.sort(numbers, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Comparator is null");
    }

    @Test
    @DisplayName("When the sort ascending")
    public void test4(){
        Assertions
                .assertThat(
                        mergeSort.sortNaturalOrder(numbers))
                .isEqualTo(numberAscending);
    }

    @Test
    @DisplayName("When the sort descending")
    public void test5(){
        Assertions
                .assertThat(
                        mergeSort.sortReversOrder(numbers))
                .isEqualTo(numberDescending);
    }
}
