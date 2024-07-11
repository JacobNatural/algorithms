package com.app.numbers.sort;

import com.app.extension.numbers.sort.SelectSortExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static com.app.numbers.sort.SortDataProvider.*;
import java.util.Comparator;
import java.util.List;

@ExtendWith(SelectSortExtension.class)
@RequiredArgsConstructor
public class SelectSortTest {

    private final SelectSort<Integer> selectSort;

    @Test
    @DisplayName("When the list is null")
    public void test1(){
        Assertions
                .assertThatThrownBy(
                        () -> selectSort.sort(null, Comparator.naturalOrder()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List is null");
    }

    @Test
    @DisplayName("When the list is empty")
    public void test2(){
        Assertions
                .assertThatThrownBy(
                        () -> selectSort.sort(List.of(), Comparator.naturalOrder()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("List is empty");
    }

    @Test
    @DisplayName("When the comparator is null")
    public void test3(){
        Assertions
                .assertThatThrownBy(
                        () -> selectSort.sort(numbers, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Comparator is null");
    }

    @Test
    @DisplayName("When the sort ascending")
    public void test4(){
        Assertions
                .assertThat(
                        selectSort.sortNaturalOrder(numbers))
                .isEqualTo(numberAscending);
    }

    @Test
    @DisplayName("When the sort descending")
    public void test5(){
        Assertions
                .assertThat(
                        selectSort.sortReversOrder(numbers))
                .isEqualTo(numberDescending);
    }
}
