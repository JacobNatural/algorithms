package com.app.numbers.sieve_eratosthenes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * The SieveEratosthenes class implements the Sieve of Eratosthenes algorithm
 * to generate prime numbers up to a specified limit and check if a number is prime.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class SieveEratosthenes {

    /**
     * An array representing whether numbers are prime or not.
     * A value of 0 indicates that the number is prime, and a value of 1 indicates that it is not prime.
     */
    private final int[] primeNumbers;

    /**
     * Generates a sieve to mark prime numbers up to a specified limit using the Sieve of Eratosthenes algorithm.
     *
     * @param n The upper limit for generating prime numbers.
     * @return A SieveEratosthenes instance containing the sieve.
     * @throws IllegalArgumentException if the limit n is less than 2.
     */
    public static SieveEratosthenes of(int n) {

        if (n < 2) {
            throw new IllegalArgumentException("Not available prime numbers till " + n);
        }

        var primeArr = new int[n + 1];

        for (int i = 2; i * i <= n; i++) {

            if (primeArr[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    primeArr[j] = 1;
                }
            }
        }

        return new SieveEratosthenes(primeArr);
    }

    /**
     * Checks if a given number is prime.
     *
     * @param number The number to check for primality.
     * @return {@code true} if the number is prime, {@code false} otherwise.
     * @throws IllegalArgumentException if the number is negative or exceeds the limit of the sieve.
     */
    public boolean isPrime(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Prime number is negative");
        }

        if (number > primeNumbers.length) {
                throw new IllegalArgumentException("Number is too large");
        }

        return primeNumbers[number] == 0;
    }
}
