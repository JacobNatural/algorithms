package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The BubbleSort class implements the Bubble Sort algorithm for sorting lists.
 * It uses a comparator to determine the order of the elements.
 *
 * @param <T> The type of elements to be sorted. It must implement {@link Comparable<T>}
 * for comparisons.
 */
@NoArgsConstructor
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    /**
     * Sorts a list of elements using the Bubble Sort algorithm and the provided comparator.
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

        var sortedArr = new ArrayList<>(list);

        for (int i = 0; i < sortedArr.size() - 1; i++) {
            for (int j = i + 1; j < sortedArr.size(); j++) {
                if (comparator.compare(sortedArr.get(i), sortedArr.get(j)) > 0) {
                    var tmp = sortedArr.get(i);
                    sortedArr.set(i, sortedArr.get(j));
                    sortedArr.set(j, tmp);
                }
            }
        }

        return sortedArr;
    }
}