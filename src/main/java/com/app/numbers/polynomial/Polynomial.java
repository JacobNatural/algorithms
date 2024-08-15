package com.app.numbers.polynomial;

import lombok.*;

/**
 * Represents a polynomial equation and provides a method to evaluate it for a given value of x.
 * The polynomial is expressed as an array of coefficients, where each index corresponds to the coefficient
 * for a term of the polynomial.
 * <p>
 * For example, the polynomial 3x^2 + 2x + 1 would have coefficients [3, 2, 1].
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Polynomial {

    /**
     * An array of coefficients representing the polynomial.
     * The coefficient at index 0 corresponds to the highest degree term, and the last index corresponds to the constant term.
     */
    private final double[] coefficients;

    /**
     * Factory method to create a Polynomial object.
     *
     * @param coefficients An array of coefficients, where each index corresponds to the coefficient of the respective term.
     *                     The highest degree term is the coefficient at index 0, and the constant term is the last element.
     * @return A {@code Polynomial} object.
     * @throws IllegalArgumentException if the coefficients array is null or empty.
     */
    public static Polynomial of(double[] coefficients) {

        if (coefficients == null) {
            throw new IllegalArgumentException("Coefficients are null");
        }

        if (coefficients.length == 0) {
            throw new IllegalArgumentException("Coefficients are empty");
        }

        return new Polynomial(coefficients);
    }

    /**
     * Evaluates the polynomial for a given value of x using Horner's method.
     * <p>
     * Horner's method is an efficient way of evaluating polynomials that minimizes the number of multiplications.
     * <p>
     * For example, if the polynomial is 3x^2 + 2x + 1 and x = 2, the method would compute:
     * result = ((3 * 2) + 2) * 2 + 1.
     *
     * @param x The value at which to evaluate the polynomial.
     * @return The result of evaluating the polynomial at the given x.
     */
    public double calculate(double x) {

        // Initialize the result with the leading coefficient
        var result = coefficients[0];

        // Use Horner's method to evaluate the polynomial
        for (int i = 1; i < coefficients.length; i++) {
            result = result * x + coefficients[i];
        }

        return result;
    }
}