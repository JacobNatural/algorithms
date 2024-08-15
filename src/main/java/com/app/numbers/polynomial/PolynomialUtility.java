package com.app.numbers.polynomial;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * A utility class for performing numerical operations on polynomials.
 * This class provides methods for numerical integration (trapezoidal and rectangle rules)
 * as well as for finding roots (zero places) using the bisection method.
 */
@AllArgsConstructor
@ToString
public class PolynomialUtility {

    /**
     * The polynomial to be used for the numerical operations.
     */
    private final Polynomial polynomial;

    /**
     * Approximates the definite integral of the polynomial using the trapezoidal rule over the interval [a, b].
     *
     * @param a The lower limit of integration.
     * @param b The upper limit of integration.
     * @param n The number of subintervals.
     * @return The approximate value of the integral.
     * @throws IllegalArgumentException if a is greater than or equal to b, or if n is less than 1.
     */
    public double trapezoidal(double a, double b, int n) {

        if (a >= b) {
            throw new IllegalArgumentException("A is higher or equal to b");
        }

        if (n < 1) {
            throw new IllegalArgumentException("N is less than one");
        }

        var baseA = polynomial.calculate(a);
        var baseB = 0.0;
        var sum = 0.0;
        var h = (b - a) / n;

        for (int i = 1; i <= n; i++) {
            baseB = polynomial.calculate(a + i * h);
            sum += baseA + baseB;
            baseA = baseB;
        }

        return sum * h * 0.5;
    }

    /**
     * Approximates the definite integral of the polynomial using the rectangle rule (midpoint rule) over the interval [a, b].
     *
     * @param a The lower limit of integration.
     * @param b The upper limit of integration.
     * @param n The number of subintervals.
     * @return The approximate value of the integral.
     * @throws IllegalArgumentException if a is greater than or equal to b, or if n is less than 1.
     */
    public double rectangle(double a, double b, int n) {

        if (a >= b) {
            throw new IllegalArgumentException("A is higher or equal to b");
        }

        if (n < 1) {
            throw new IllegalArgumentException("N is less than one");
        }

        var sideLength = (b - a) / n;
        var middle = a + (sideLength / 2);
        var sum = 0.0;

        for (int i = 1; i <= n; i++) {
            sum += polynomial.calculate(middle);
            middle += sideLength;
        }

        return sum * sideLength;
    }

    /**
     * Finds the root (zero place) of the polynomial within the interval [x1, x2] using the bisection method.
     * <p>
     * This method iteratively refines the interval until it contains the root with a precision specified by epsilon.
     *
     * @param x1      The lower bound of the interval.
     * @param x2      The upper bound of the interval.
     * @param epsilon The acceptable error for the root (must be between 0 and 1).
     * @return The approximate value of the root.
     * @throws IllegalArgumentException if epsilon is out of the range (0, 1), or if the polynomial does not have opposite signs at x1 and x2.
     */
    public double calculateZeroPlaces(double x1, double x2, double epsilon) {

        if (epsilon <= 0 || epsilon >= 1) {
            throw new IllegalArgumentException("Epsilon is incorrect");
        }

        var funA = polynomial.calculate(x1);
        var funB = polynomial.calculate(x2);

        if (funA * funB > 0) {
            throw new IllegalArgumentException("The function does not meet the assumptions");
        }

        var c = 0.0;

        while ((x2 - x1) >= epsilon) {

            c = (x1 + x2) / 2;
            var fun0 = polynomial.calculate(c);

            if (Math.abs(fun0) < epsilon) {
                return c;
            }

            if (funA * fun0 < 0) {
                x2 = c;
            } else {
                x1 = c;
            }
        }

        return c;
    }
}