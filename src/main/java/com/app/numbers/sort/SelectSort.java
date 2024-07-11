package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Select sort.
 *
 * @param <T> the type parameter
 */
@NoArgsConstructor
public class SelectSort<T extends Comparable<T>>implements Sort<T>{

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

        var  index = 0;
        for(int i = 0; i < sortedList.size(); i++){
            index = i;
            for(int j = i + 1; j < sortedList.size(); j++){
                if(comparator.compare(sortedList.get(index), sortedList.get(j)) > 0){
                    index = j;
                }
            }
            var temp = sortedList.get(i);
            sortedList.set(i,sortedList.get(index));
            sortedList.set(index,temp);
        }

        return sortedList;
    }
}
