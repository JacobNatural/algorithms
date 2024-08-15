package com.app.numbers.fibo;

import lombok.NoArgsConstructor;

/**
 * The {@code FibonacciIterative} class provides an implementation of the Fibonacci sequence
 * using an iterative approach. This method computes Fibonacci numbers with a time complexity
 * of O(n) and a space complexity of O(1), making it both efficient in terms of execution time
 * and memory usage.
 *
 * <p>This iterative approach is more space-efficient compared to dynamic programming as it
 * only uses a fixed amount of additional space, regardless of the value of {@code n}.</p>
 */
@NoArgsConstructor
public class FibonacciIterative implements Fibonacci {

    /**
     * Computes the Fibonacci number at the specified position using an iterative approach.
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

        var a = 0;
        var b = 1;
        var result = 0;

        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
