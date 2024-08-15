package com.app.numbers.fibo;

/**
 * The {@code Fibonacci} interface defines a contract for calculating Fibonacci numbers.
 * Implementations of this interface should provide a way to compute the Fibonacci value
 * for a given position in the Fibonacci sequence.
 */
public interface Fibonacci {

    /**
     * Calculates the Fibonacci number at the specified position in the sequence.
     *
     * @param n The position in the Fibonacci sequence (0-based index).
     *          Must be a non-negative integer.
     * @return The Fibonacci number at the specified position.
     * @throws IllegalArgumentException If {@code n} is negative.
     */
    int value(int n);
}
