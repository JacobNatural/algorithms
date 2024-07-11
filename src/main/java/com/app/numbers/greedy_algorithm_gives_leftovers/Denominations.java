package com.app.numbers.greedy_algorithm_gives_leftovers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The type Denominations.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Denominations {
    private final Set<Integer> availableDenominations;

    /**
     * Of denominations.
     *
     * @param availableDenominations the available denominations
     * @return the denominations
     */
    public static Denominations of(Set<Integer> availableDenominations){

        if(availableDenominations == null){
            throw new IllegalArgumentException("Available denominations is null");
        }

        if(availableDenominations.isEmpty()){
            throw new IllegalArgumentException("Available denominations is empty");
        }

        return new  Denominations(
                availableDenominations
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
    }


    /**
     * Calculate nominals list.
     *
     * @param payment the payment
     * @param price   the price
     * @return the list
     */
    public List<Integer> calculateNominals(int payment, int price){

        if(payment <= 0){
            throw new IllegalArgumentException("Payment is negative or null");
        }

        if(price <= 0){
            throw new IllegalArgumentException("Price is negative or null");
        }

        var rest = payment - price;

        if(rest < 0){
            throw new IllegalArgumentException("Payment is less than price");
        }

        var nominals = new ArrayList<Integer>();

        for(var nominal : availableDenominations) {
            while (rest >= nominal){
                nominals.add(nominal);
                rest -= nominal;
            }
        }

        if(rest > 0){
            throw new IllegalArgumentException("Not possible to calculate nominals");
        }

        return nominals;
    }
}
