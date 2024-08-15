package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The InsertSort class implements the Insertion Sort algorithm for sorting lists.
 * It uses a comparator to determine the order of the elements.
 *
 * @param <T> The type of elements to be sorted. It must implement {@link Comparable<T>}
 * for comparisons.
 */
@NoArgsConstructor
public class InsertSort<T extends Comparable<T>> implements Sort<T> {

    /**
     * Sorts a list of elements using the Insertion Sort algorithm and the provided comparator.
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

        for (int i = 1; i < sortedList.size(); i++) {

            var key = sortedList.get(i);
            var j = i - 1;

            while (j >= 0 && comparator.compare(sortedList.get(j), key) > 0) {
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, key);
        }

        return sortedList;
    }
}