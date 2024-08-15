package com.app.numbers.fibo;

import lombok.NoArgsConstructor;

/**
 * The {@code FibonacciDynamic} class provides an implementation of the Fibonacci sequence
 * using a dynamic programming approach. This method computes Fibonacci numbers iteratively
 * with a time complexity of O(n) and a space complexity of O(n).
 *
 * <p>This implementation is efficient for larger values of {@code n} compared to the
 * naive recursive approach, as it avoids redundant calculations.</p>
 */
@NoArgsConstructor
public class FibonacciDynamic implements Fibonacci {

    /**
     * Computes the Fibonacci number at the specified position using dynamic programming.
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

        var fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}