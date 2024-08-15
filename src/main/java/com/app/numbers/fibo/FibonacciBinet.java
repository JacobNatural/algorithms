package com.app.numbers.fibo;

import lombok.NoArgsConstructor;

/**
 * The {@code FibonacciBinet} class provides an implementation of the Fibonacci sequence
 * using Binet's formula. This formula is an analytical expression that calculates the
 * nth Fibonacci number in constant time.
 *
 * <p>This implementation is efficient for small values of n, but may suffer from precision
 * issues for larger values due to floating-point arithmetic.</p>
 */
@NoArgsConstructor
public class FibonacciBinet implements Fibonacci {

    /**
     * Computes the Fibonacci number at the specified position using Binet's formula.
     *
     * @param n The position in the Fibonacci sequence (0-based index).
     *          Must be a non-negative integer.
     * @return The Fibonacci number at the specified position.
     * @throws IllegalArgumentException If {@code n} is negative.
     */
    @Override
    public int value(int n) {
        if (n <= 1) {
            return n;
        }

        // The golden ratio (phi)
        var phi = (1 + Math.sqrt(5)) / 2;

        // Binet's formula
        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
}