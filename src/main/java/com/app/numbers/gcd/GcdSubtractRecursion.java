package com.app.numbers.gcd;

import lombok.NoArgsConstructor;

/**
 * The {@code GcdSubtractRecursion} class provides an implementation of the {@code Gcd} interface
 * using a recursive subtraction algorithm to compute the Greatest Common Divisor (GCD) of two integers.
 *
 * <p>The subtraction algorithm for computing the GCD recursively subtracts the smaller number from the larger number
 * until both numbers are equal. At this point, the common value is the GCD of the original two numbers.</p>
 */
@NoArgsConstructor
public class GcdSubtractRecursion implements Gcd {

    /**
     * Computes the Greatest Common Divisor (GCD) of two integers using a recursive subtraction algorithm.
     *
     * <p>This method computes the GCD of two integers {@code a} and {@code b} by recursively subtracting the smaller
     * number from the larger number until both numbers become equal. The resulting value is the GCD. If either of the
     * numbers is zero, the non-zero number is returned as the GCD.</p>
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

        if (a == b) {
            return a;
        }

        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        if (a > b) {
            return value(a - b, b);
        } else {
            return value(a, b - a);
        }
    }
}
