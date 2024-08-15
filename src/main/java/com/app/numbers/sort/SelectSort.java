package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The SelectSort class implements the Selection Sort algorithm for sorting lists.
 * It uses a comparator to define the order of the elements.
 *
 * @param <T> The type of elements to be sorted. It must implement {@link Comparable<T>}
 * for comparisons.
 */
@NoArgsConstructor
public class SelectSort<T extends Comparable<T>> implements Sort<T> {

    /**
     * Sorts a list of elements using the Selection Sort algorithm and the provided comparator.
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

        // Selection Sort Algorithm
        for (int i = 0; i < sortedList.size(); i++) {
            // Assume the minimum element is the first element
            int index = i;

            // Check the rest of the list for a smaller element
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (comparator.compare(sortedList.get(index), sortedList.get(j)) > 0) {
                    index = j;
                }
            }

            // Swap the found minimum element with the first element
            var temp = sortedList.get(i);
            sortedList.set(i, sortedList.get(index));
            sortedList.set(index, temp);
        }

        return sortedList;
    }
}
