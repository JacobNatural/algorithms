package com.app.numbers.fibo;

import lombok.NoArgsConstructor;

/**
 * The type Fibonacci iterative.
 */
@NoArgsConstructor
public class FibonacciIterative implements Fibonacci{
    public int value(int n) {

        if (n <= 1) {
            return n;
        }

        var a = 0;
        var b = 1;
        var result = 0;

        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }
}
