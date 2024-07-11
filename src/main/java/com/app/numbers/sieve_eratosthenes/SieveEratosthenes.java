package com.app.numbers.sieve_eratosthenes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * The type Sieve eratosthenes.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class SieveEratosthenes {
    private final int[] primeNumbers;

    /**
     * Of sieve eratosthenes.
     *
     * @param n the n
     * @return the sieve eratosthenes
     */
    public static SieveEratosthenes of(int n) {

        if(n < 2){
                throw new IllegalArgumentException("Not available prime numbers till " + n);
        }
        var primeArr = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {

            if (primeArr[i] == 0) {
                for (int j = i * i; j <= n ; j += i) {
                    primeArr[j] = 1;
                }
            }
        }
        return new SieveEratosthenes(primeArr);
    }

    /**
     * Is prime boolean.
     *
     * @param number the number
     * @return the boolean
     */
    public boolean isPrime(int number){

        if (number < 0) {
            throw new IllegalArgumentException("Prime number is negative");
        }

        if(number > primeNumbers.length){
            throw new IllegalArgumentException("Number is too large");
        }
        return primeNumbers[number] == 0;
    }
}
