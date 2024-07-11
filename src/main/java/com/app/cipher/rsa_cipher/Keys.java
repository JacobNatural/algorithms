package com.app.cipher.rsa_cipher;

import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * The type Keys.
 */
@AllArgsConstructor
public class Keys {

    /**
     * The Public key.
     */
    final BigInteger publicKey;
    /**
     * The Private key.
     */
    final BigInteger privateKey;
    /**
     * The Key 2.
     */
    final BigInteger key2;


    /**
     * Of keys.
     *
     * @return the keys
     */
    public static Keys of(){

        var keys = generateKeys();
       return new Keys(keys.get(0), keys.get(1), keys.get(2));
    }

    /**
     * Generate keys list.
     *
     * @return the list
     */
    static List<BigInteger> generateKeys() {

        var primeNumbers = GeneratePrimeNumbers.generate(500);
        var p =  primeNumbers.get(new Random().nextInt(0, primeNumbers.size()));
        var q = primeNumbers.get(new Random().nextInt(0, primeNumbers.size()));
        var key2 = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        var funEuler = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        var publicKey = findRelativelyPrimeNumber(funEuler, primeNumbers);
        var privateKey = publicKey.modInverse(funEuler);
        return  new ArrayList<>(List.of(publicKey,privateKey,key2));
    }

    private static BigInteger findRelativelyPrimeNumber(BigInteger funEuler, List<Integer> primeNumbers) {

        for (var x : primeNumbers) {
            if (funEuler.remainder(BigInteger.valueOf(x)).compareTo(BigInteger.ZERO) > 0) {

                return BigInteger.valueOf(x);
            }
        }
        throw new IllegalArgumentException("we could not get relatively prime number!!");
    }
}
