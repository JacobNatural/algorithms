package com.app.numbers.gcd;

import lombok.NoArgsConstructor;

/**
 * The type Gcd subtract recursion.
 */
@NoArgsConstructor
public class GcdSubtractRecursion implements Gcd{

    @Override
    public int value(int a, int b) {

        if(a < 0){
            throw new IllegalArgumentException("Argument a is negative");
        }

        if(b < 0){
            throw new IllegalArgumentException("Argument b is negative");
        }

        if(a == b){
            return a;
        }

        if(a == 0){
            return b;
        }

        if(b == 0){
            return a;
        }

        if(a > b){
            return value(a - b, b);
        }else {
            return value(a, b - a);
        }

    }
}
