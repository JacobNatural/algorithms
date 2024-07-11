package com.app.numbers.sort;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * The type Merge sort.
 *
 * @param <T> the type parameter
 */
@NoArgsConstructor
public class MergeSort<T extends Comparable<T>> implements   Sort<T>{

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
        mergeSort(sortedList, 0, sortedList.size() -1,comparator);

        return sortedList;
    }

    private static <T> void mergeSort(List<T> list, int begin, int end, Comparator<T>comparator){

        if(begin < end){
            var middle = (begin + end) / 2;
            mergeSort(list, begin, middle,comparator);
            mergeSort(list, middle + 1, end, comparator);
            merge(list, begin, middle, end, comparator);
        }
    }

    private static <T> void merge(List<T> list, int begin, int middle, int end, Comparator<T> comparator){

        var extraArr = new ArrayList<>(list);

        var finger1 = begin;
        var finger2 = middle + 1;
        var current = begin;

        while (finger1 <= middle && finger2 <= end){
            if(comparator.compare(extraArr.get(finger1), extraArr.get(finger2)) < 0){
                list.set(current, extraArr.get(finger1));
                finger1++;
            }else {
                list.set(current, extraArr.get(finger2));
                finger2++;
            }
            current++;
        }

        while (finger1 <= middle){
            list.set(current, extraArr.get(finger1));
            finger1++;
            current++;
        }
    }
}
