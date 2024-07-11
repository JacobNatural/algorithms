package com.app.numbers.fibo;


import lombok.NoArgsConstructor;

/**
 * The type Fibonacci dynamic.
 */
@NoArgsConstructor
public class FibonacciDynamic implements Fibonacci{
    public int value(int n) {

        if(n <= 1){
            return n;
        }

        var fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
