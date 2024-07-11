package com.app.numbers.sort;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Insert sort.
 *
 * @param <T> the type parameter
 */
@NoArgsConstructor
public class InsertSort<T extends Comparable<T>> implements Sort<T>{


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

        for (int i = 1; i < sortedList.size(); i++) {

            var key = sortedList.get(i);
            var j = i - 1;

            while (j >= 0 && (comparator.compare(sortedList.get(j), key) > 0)){
                sortedList.set(j + 1, sortedList.get(j));
                j--;
            }
            sortedList.set(j + 1, key);
        }

        return sortedList;
    }
}
