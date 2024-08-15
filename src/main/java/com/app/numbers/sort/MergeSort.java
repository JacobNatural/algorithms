package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The MergeSort class implements the Merge Sort algorithm for sorting lists.
 * It uses a comparator to determine the order of the elements.
 *
 * @param <T> The type of elements to be sorted. It must implement {@link Comparable<T>}
 * for comparisons.
 */
@NoArgsConstructor
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    /**
     * Sorts a list of elements using the Merge Sort algorithm and the provided comparator.
     *
     * @param list       The list of elements to be sorted. Must not be null or empty.
     * @param comparator A comparator that defines the order of elements. Must not be null.
     * @return A new list containing the sorted elements.
     * @throws IllegalArgumentException if the list is null, empty, or the comparator is null.
     */
    @Override
    public List<T> sort(List<T> list, Comparator<T> comparator) {

        if (list == null) {
            throw new IllegalArgumentException("List is null");
        }

        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        if (comparator == null) {
            throw new IllegalArgumentException("Comparator is null");
        }

        var sortedList = new ArrayList<>(list);
        mergeSort(sortedList, 0, sortedList.size() - 1, comparator);

        return sortedList;
    }

    /**
     * Recursively divides the list into smaller sublists and merges them back together in sorted order.
     *
     * @param list       The list of elements to be sorted.
     * @param begin      The starting index of the sublist.
     * @param end        The ending index of the sublist.
     * @param comparator A comparator used to compare elements.
     */
    private static <T> void mergeSort(List<T> list, int begin, int end, Comparator<T> comparator) {

        if (begin < end) {
            var middle = (begin + end) / 2;
            mergeSort(list, begin, middle, comparator);
            mergeSort(list, middle + 1, end, comparator);
            merge(list, begin, middle, end, comparator);
        }
    }

    /**
     * Merges two sorted sublists into a single sorted sublist.
     *
     * @param list       The list containing the sublists to be merged.
     * @param begin      The starting index of the first sublist.
     * @param middle     The ending index of the first sublist and the starting index of the second sublist.
     * @param end        The ending index of the second sublist.
     * @param comparator A comparator used to compare elements.
     */
    private static <T> void merge(List<T> list, int begin, int middle, int end, Comparator<T> comparator) {

        var extraArr = new ArrayList<>(list);

        var finger1 = begin;
        var finger2 = middle + 1;
        var current = begin;

        while (finger1 <= middle && finger2 <= end) {
            if (comparator.compare(extraArr.get(finger1), extraArr.get(finger2)) < 0) {
                list.set(current, extraArr.get(finger1));
                finger1++;
            } else {
                list.set(current, extraArr.get(finger2));
                finger2++;
            }
            current++;
        }

        while (finger1 <= middle) {
            list.set(current, extraArr.get(finger1));
            finger1++;
            current++;
        }
    }
}
