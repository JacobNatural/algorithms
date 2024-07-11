package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Quick sort.
 *
 * @param <T> the type parameter
 */
@NoArgsConstructor
public class QuickSort<T extends Comparable<T>> implements Sort<T>{
    public List<T> sort(List<T> list, Comparator<T> comparator){

        if(list == null){
            throw new IllegalArgumentException("List is null");
        }

        if(list.isEmpty()){
            throw new IllegalArgumentException("List is empty");
        }

        if(comparator == null){
            throw new IllegalArgumentException("Comparator is null");
        }

        var sortedList = new ArrayList<>(list);
        sort(sortedList,0, sortedList.size() - 1  , comparator);

        return sortedList;
    }
    private static<T> void sort(List<T> list, int left, int right, Comparator<T> comparator) {

        var pivot = list.get((left + right) / 2);
        var i = left;
        var j = right;

        do {
            while (comparator.compare(list.get(i), pivot) < 0){
                i++;
            }
            while (comparator.compare(list.get(j), pivot) > 0){
                j--;
            }
            if (i <= j) {
                var tmp = list.get(i);
                list.set(i,  list.get(j));
                list.set(j,  tmp);
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
