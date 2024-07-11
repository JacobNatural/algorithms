package com.app.numbers.fibo;

import lombok.NoArgsConstructor;

/**
 * The type Fibonacci binet.
 */
@NoArgsConstructor
public class FibonacciBinet implements Fibonacci{
    public int value(int n) {

        if(n <= 1){
            return n;
        }

        var phi = (1 + Math.sqrt(5)) / 2;

        return (int) Math.round(Math.pow(phi, n) / Math.sqrt(5));
    }
}
