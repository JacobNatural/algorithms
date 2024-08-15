package com.app.numbers.greedy_algorithm_gives_leftovers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a set of denominations (e.g., coins, bills) that can be used to calculate change.
 * The class uses a greedy algorithm to find the minimal number of denominations that can make up the difference between a payment and a price.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class GreedyChangeMaker {
    /**
     * A set of available denominations. This set is immutable and sorted in descending order.
     */
    private final Set<Integer> availableDenominations;

    /**
     * Creates a Denominations object with a set of available denominations sorted in descending order.
     *
     * @param availableDenominations The set of denominations that are available for calculating the change.
     * @return A {@code Denominations} object containing the sorted set of available denominations.
     * @throws IllegalArgumentException if the provided set is {@code null} or empty.
     */
    public static GreedyChangeMaker of(Set<Integer> availableDenominations) {

        if (availableDenominations == null) {
            throw new IllegalArgumentException("Available denominations is null");
        }

        if (availableDenominations.isEmpty()) {
            throw new IllegalArgumentException("Available denominations is empty");
        }

        return new GreedyChangeMaker(
                availableDenominations
                        .stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    /**
     * Calculates the list of denominations that represent the change when the payment is greater than the price.
     * The method uses a greedy algorithm to subtract the largest possible denomination from the remaining change
     * until the change has been fully represented.
     *
     * @param payment The amount of money given by the customer.
     * @param price   The cost of the product or service.
     * @return A list of denominations that make up the change, in descending order.
     * @throws IllegalArgumentException if the payment or price are non-positive,
     *                                  or if the payment is less than the price,
     *                                  or if it is not possible to represent the change using the available denominations.
     */
    public List<Integer> calculateNominals(int payment, int price) {

        if (payment <= 0) {
            throw new IllegalArgumentException("Payment is negative or null");
        }

        if (price <= 0) {
            throw new IllegalArgumentException("Price is negative or null");
        }

        var rest = payment - price;

        if (rest < 0) {
            throw new IllegalArgumentException("Payment is less than price");
        }

        var nominals = new ArrayList<Integer>();

        for (var nominal : availableDenominations) {
            while (rest >= nominal) {
                nominals.add(nominal);
                rest -= nominal;
            }
        }

        if (rest > 0) {
            throw new IllegalArgumentException("Not possible to calculate nominals");
        }

        return nominals;
    }
}