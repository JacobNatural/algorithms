package com.app.numbers.gcd;

import lombok.NoArgsConstructor;

/**
 * The {@code GcdEuclidIteration} class provides an implementation of the Greatest Common Divisor (GCD)
 * computation using the iterative approach of Euclid's algorithm. This approach calculates the GCD of two
 * integers by repeatedly applying the modulo operation until one of the integers becomes zero.
 *
 * <p>Euclid's algorithm is efficient for computing the GCD with a time complexity of O(log(min(a, b))), where
 * {@code a} and {@code b} are the input integers.</p>
 */
@NoArgsConstructor
public class GcdEuclidIteration implements Gcd {

    /**
     * Computes the Greatest Common Divisor (GCD) of two non-negative integers using Euclid's algorithm.
     *
     * @param a The first non-negative integer.
     * @param b The second non-negative integer.
     * @return The GCD of the two integers.
     * @throws IllegalArgumentException If either {@code a} or {@code b} is negative.
     */
    @Override
    public int value(int a, int b) {

        if (a < 0) {
            throw new IllegalArgumentException("Argument a is negative");
        }

        if (b < 0) {
            throw new IllegalArgumentException("Argument b is negative");
        }

        while (b != 0) {
            var temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
