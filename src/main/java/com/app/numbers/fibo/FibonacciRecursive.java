package com.app.numbers.fibo;

import lombok.NoArgsConstructor;

/**
 * The {@code FibonacciRecursive} class provides an implementation of the Fibonacci sequence
 * using a recursive approach. This method computes Fibonacci numbers by recursively calling
 * itself to calculate the values at the previous two positions in the sequence.
 *
 * <p>This recursive approach is a straightforward implementation but is less efficient compared
 * to iterative or dynamic programming approaches due to its exponential time complexity of O(2^n).
 * It may lead to performance issues for large values of {@code n} due to repeated calculations.</p>
 */
@NoArgsConstructor
public class FibonacciRecursive implements Fibonacci {

    /**
     * Computes the Fibonacci number at the specified position using a recursive approach.
     *
     * @param n The position in the Fibonacci sequence (0-based index).
     *          Must be a non-negative integer.
     * @return The Fibonacci number at the specified position.
     */
    @Override
    public int value(int n) {
        if (n <= 1) {
            return n;
        }

        return value(n - 1) + value(n - 2);
    }
}