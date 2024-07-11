package com.app.numbers.polynomial;
import lombok.*;

/**
 * The type Polynomial.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Polynomial {

    private final double[] coefficients;

    /**
     * Of polynomial.
     *
     * @param coefficients the coefficients
     * @return the polynomial
     */
    public static Polynomial of(double[] coefficients){

        if(coefficients == null){
            throw new IllegalArgumentException("Coefficients are null");
        }

        if(coefficients.length == 0){
            throw new IllegalArgumentException("Coefficients are empty");
        }

        return new Polynomial(coefficients);
    }


    /**
     * Calculate double.
     *
     * @param x the x
     * @return the double
     */
    public double calculate(double x) {

        var result = coefficients[0];

        for (int i = 1; i < coefficients.length; i++) {
            result = result * x + coefficients[i];
        }

        return result;
    }
}
