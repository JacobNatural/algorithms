package com.app.numbers.gcd;

/**
 * The {@code Gcd} interface defines a contract for computing the Greatest Common Divisor (GCD) of two integers.
 * Implementations of this interface should provide a method to calculate the GCD based on different algorithms.
 *
 * <p>The Greatest Common Divisor (GCD) of two integers is the largest positive integer that divides both of the integers
 * without leaving a remainder. Various algorithms can be used to compute the GCD, including Euclid's algorithm,
 * the extended Euclidean algorithm, and more.</p>
 */
public interface Gcd {

    /**
     * Computes the Greatest Common Divisor (GCD) of two integers.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the two integers.
     */
    int value(int a, int b);
}
