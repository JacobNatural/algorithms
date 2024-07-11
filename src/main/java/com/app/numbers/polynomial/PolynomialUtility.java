package com.app.numbers.polynomial;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * The type Polynomial utility.
 */
@AllArgsConstructor
@ToString
public class PolynomialUtility {
    private final Polynomial polynomial;


    /**
     * Trapezoidal double.
     *
     * @param a the a
     * @param b the b
     * @param n the n
     * @return the double
     */
    public double trapezoidal(double a, double b, int n){

        if(a >= b){
            throw new IllegalArgumentException("A is higher or equal to b");
        }

        if(n < 1){
            throw new IllegalArgumentException("N is less than one");
        }

        var baseA = polynomial.calculate(a);
        var baseB = 0.0;
        var sum = 0.0;
        var h = (b - a) / n;

        for(int i  = 1; i <= n; i++){

            baseB = polynomial.calculate(a + i * h);
            sum += baseA + baseB;
            baseA = baseB;
        }

        return sum * h * 0.5 ;
    }

    /**
     * Rectangle double.
     *
     * @param a the a
     * @param b the b
     * @param n the n
     * @return the double
     */
    public double rectangle(double a, double b, int n){

        if(a >= b){
            throw new IllegalArgumentException("A is higher or equal to b");
        }

        if(n < 1){
            throw new IllegalArgumentException("N is less than one");
        }

        var sideLength = (b - a) / n;
        var middel = a + (sideLength / 2);
        var sum = 0.0;

        for(int i = 1; i <= n; i++){
            sum += polynomial.calculate(middel );
            middel += sideLength;
        }

        return sum * sideLength;
    }


    /**
     * Calculate zero places double.
     *
     * @param x1       the x1
     * @param x2       the x2
     * @param epsilon the epsilon
     * @return the double
     */
    public double calculateZeroPlaces(double x1, double x2, double epsilon){

        if(epsilon < 0 || epsilon >= 1){
            throw new IllegalArgumentException("Epsilon is incorrect");
        }

        var funA = polynomial.calculate(x1);
        var funB = polynomial.calculate(x2);

        if(funA * funB > 0){
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
