package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A interface with tool for bubble sort
 *
 * @param <T> the type parameter
 */
@NoArgsConstructor()
public class BubbelSort<T extends Comparable<T>> implements Sort<T>{
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

        var sortedArr = new ArrayList<>(list);

        for(int i = 0; i < sortedArr.size() - 1; i++){

            for(int j = i + 1; j < sortedArr.size() ; j++){

                if(comparator.compare(sortedArr.get(i), sortedArr.get(j)) > 0){
                    var tmp = sortedArr.get(i);
                    sortedArr.set(i,sortedArr.get(j));
                    sortedArr.set(j, tmp);
                }
            }
        }
        return sortedArr;
    }
}
