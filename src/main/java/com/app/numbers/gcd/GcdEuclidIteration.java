package com.app.numbers.gcd;

import lombok.NoArgsConstructor;

/**
 * The type Gcd euclid iteration.
 */
@NoArgsConstructor
public class GcdEuclidIteration implements Gcd{

    @Override
    public int value(int a, int b) {

        if(a < 0){
            throw new IllegalArgumentException("Argument a is negative");
        }

        if(b < 0){
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
