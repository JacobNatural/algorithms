package com.app.cipher.rsa_cipher;

import com.app.numbers.utility.iteration.NumberUtilityIteration;

import java.util.ArrayList;
import java.util.List;

/**
 * The interface Generate prime numbers.
 */
public interface GeneratePrimeNumbers {
    /**
     * Generate list.
     *
     * @param max       the max

     * @return the list
     */
    static List<Integer> generate(int max){

        if(max < 2){
            throw new IllegalArgumentException("Minimum max is 2");
        }

        var primeNumbers = new ArrayList<Integer>();

        for(int i = 2; i <= max; i++){
            if(NumberUtilityIteration.isPrime(i)){
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
