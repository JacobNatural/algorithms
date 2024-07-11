package com.app.numbers.gcd;

import lombok.NoArgsConstructor;

/**
 * The type Gcd euclid recursion.
 */
@NoArgsConstructor
public class GcdEuclidRecursion implements Gcd{

    @Override
    public int value(int a, int b) {

        if(a < 0){
            throw new IllegalArgumentException("Argument a is negative");
        }

        if(b < 0){
            throw new IllegalArgumentException("Argument b is negative");
        }

        if (b == 0) {
            return a;
        } else {
            return value(b, a % b);
        }
    }
}
