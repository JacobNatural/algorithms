package com.app.numbers.gcd;

import lombok.NoArgsConstructor;

/**
 * The {@code GcdEuclidRecursion} class provides an implementation of the {@code Gcd} interface
 * using the recursive Euclidean algorithm to compute the Greatest Common Divisor (GCD) of two integers.
 *
 * <p>The Euclidean algorithm for computing the GCD is based on the principle that the GCD of two numbers also divides their difference.
 * The recursive version of this algorithm repeatedly applies this principle until one of the numbers becomes zero.</p>
 */
@NoArgsConstructor
public class GcdEuclidRecursion implements Gcd {

    /**
     * Computes the Greatest Common Divisor (GCD) of two integers using the recursive Euclidean algorithm.
     *
     * <p>This method computes the GCD of two integers {@code a} and {@code b} by recursively applying the Euclidean algorithm.
     * The base case for the recursion is when {@code b} becomes zero, in which case {@code a} is the GCD. Otherwise, the method
     * is called recursively with {@code b} and {@code a % b}.</p>
     *
     * @param a The first integer.
     * @param b The second integer.
     * @return The GCD of the two integers.
     * @throws IllegalArgumentException if either {@code a} or {@code b} is negative.
     */
    @Override
    public int value(int a, int b) {

        if (a < 0) {
            throw new IllegalArgumentException("Argument a is negative");
        }

        if (b < 0) {
            throw new IllegalArgumentException("Argument b is negative");
        }

        if (b == 0) {
            return a;
        } else {
            return value(b, a % b);
        }
    }
}
