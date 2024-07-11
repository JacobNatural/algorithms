package com.app.numbers.gcd;

import lombok.NoArgsConstructor;

/**
 * The type Gcd subtract iteration.
 */
@NoArgsConstructor
public class GcdSubtractIteration implements Gcd{

    @Override
    public int value(int a, int b) {
        if(a < 0){
            throw new IllegalArgumentException("Argument a is negative");
        }

        if(b < 0){
            throw new IllegalArgumentException("Argument b is negative");
        }

        if(a == 0){
            return b;
        }
        if(b == 0){
            return a;
        }

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
