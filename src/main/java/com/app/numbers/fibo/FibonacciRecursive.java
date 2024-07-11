package com.app.numbers.fibo;


import lombok.NoArgsConstructor;

/**
 * The type Fibonacci recursive.
 */
@NoArgsConstructor
public class FibonacciRecursive implements Fibonacci{
    public int value(int n ){
        if (n <= 1) {
            return n;
        }

        return value(n-1) + value(n-2);
    }
}
