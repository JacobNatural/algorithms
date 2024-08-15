package com.app.cipher.rsa_cipher;

import com.app.numbers.utility.iteration.NumberUtilityIteration;

import java.util.ArrayList;
import java.util.List;

/**
 * The GeneratePrimeNumbers interface provides a method to generate prime numbers up to a given maximum value.
 */
public interface GeneratePrimeNumbers {

    /**
     * Generates a list of prime numbers up to the specified maximum value.
     * This method iterates through all numbers starting from 2 up to the specified maximum
     * and checks if each number is prime using the {@link NumberUtilityIteration#isPrime(int)} method.
     *
     * @param max The maximum value up to which prime numbers will be generated.
     *            The minimum acceptable value for max is 2.
     * @return A list of prime numbers from 2 to the specified max value.
     * @throws IllegalArgumentException if the max value is less than 2.
     */
    static List<Integer> generate(int max) {
        if (max < 2) {
            throw new IllegalArgumentException("Minimum max is 2");
        }

        var primeNumbers = new ArrayList<Integer>();

        for (int i = 2; i <= max; i++) {
            if (NumberUtilityIteration.isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}