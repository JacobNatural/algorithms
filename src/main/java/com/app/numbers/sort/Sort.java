package com.app.numbers.sort;

import java.util.Comparator;
import java.util.List;

/**
 * The Sort interface defines methods for sorting lists of elements.
 * Implementations of this interface should provide concrete sorting algorithms.
 *
 * @param <T> The type of elements to be sorted. It must implement {@link Comparable<T>}
 * for comparisons.
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * Sorts the provided list in natural order using Comparator.naturalOrder().
     *
     * @param arr The list of elements to be sorted. Must not be null or empty.
     * @return A new list containing the elements sorted in natural order.
     * @throws IllegalArgumentException if the list is null or empty.
     */
    default List<T> sortNaturalOrder(List<T> arr) {
        return sort(arr, Comparator.naturalOrder());
    }

    /**
     * Sorts the provided list in reverse order using Comparator.reverseOrder().
     *
     * @param arr The list of elements to be sorted. Must not be null or empty.
     * @return A new list containing the elements sorted in reverse order.
     * @throws IllegalArgumentException if the list is null or empty.
     */
    default List<T> sortReversOrder(List<T> arr) {
        return sort(arr, Comparator.reverseOrder());
    }

    /**
     * Sorts the provided list using the specified comparator.
     *
     * @param arr        The list of elements to be sorted. Must not be null or empty.
     * @param comparator A comparator that defines the order of elements. Must not be null.
     * @return A new list containing the elements sorted according to the provided comparator.
     * @throws IllegalArgumentException if the list or comparator is null.
     */
    List<T> sort(List<T> arr, Comparator<T> comparator);
}
