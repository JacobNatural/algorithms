package com.app.numbers.sort;

import java.util.Comparator;
import java.util.List;

/**
 * The interface Sort.
 *
 * @param <T> the type parameter
 */
public interface Sort <T extends Comparable<T>>{

    /**
     * Sort natural order list.
     *
     * @param arr the arr
     * @return the list
     */
    default List<T> sortNaturalOrder(List<T> arr){
        return sort(arr, Comparator.naturalOrder());
    }

    /**
     * Sort revers order list.
     *
     * @param arr the arr
     * @return the list
     */
    default List<T> sortReversOrder(List<T> arr){
        return sort(arr, Comparator.reverseOrder());
    }

    /**
     * Sort list.
     *
     * @param arr        the arr
     * @param comparator the comparator
     * @return the list
     */
    List<T> sort(List<T> arr, Comparator<T> comparator);
}
