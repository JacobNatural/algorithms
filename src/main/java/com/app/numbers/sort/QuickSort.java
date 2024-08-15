package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The QuickSort class implements the Quick Sort algorithm for sorting lists.
 * It uses a comparator to define the order of the elements.
 *
 * @param <T> The type of elements to be sorted. It must implement {@link Comparable<T>}
 * for comparisons.
 */
@NoArgsConstructor
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    /**
     * Sorts a list of elements using the Quick Sort algorithm and the provided comparator.
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
        sort(sortedList, 0, sortedList.size() - 1, comparator);

        return sortedList;
    }

    /**
     * Recursively sorts the elements in the list between indices left and right using the Quick Sort algorithm.
     *
     * @param list       The list of elements to be sorted.
     * @param left       The starting index of the sublist.
     * @param right      The ending index of the sublist.
     * @param comparator A comparator used to compare elements.
     */
    private static <T> void sort(List<T> list, int left, int right, Comparator<T> comparator) {

        var pivot = list.get((left + right) / 2);
        var i = left;
        var j = right;

        do {
            while (comparator.compare(list.get(i), pivot) < 0) {
                i++;
            }
            while (comparator.compare(list.get(j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                var tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
                i++;
                j--;
            }

        } while (i <= j);

        if (j > left) {
            sort(list, left, j, comparator);
        }
        if (i < right) {
            sort(list, i, right, comparator);
        }
    }
}