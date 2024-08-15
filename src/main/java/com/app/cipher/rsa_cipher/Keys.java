package com.app.cipher.rsa_cipher;

import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The {@code Keys} class represents the RSA encryption keys, including the public, private, and the product of two prime numbers (key2).
 * It provides methods to generate these keys and create an instance of the class using those keys.
 */
@AllArgsConstructor
public class Keys {

    /**
     * The public key used for encryption.
     */
    final BigInteger publicKey;

    /**
     * The private key used for decryption.
     */
    final BigInteger privateKey;

    /**
     * The product of two prime numbers used as the modulus (key2) in the RSA algorithm.
     */
    final BigInteger key2;

    /**
     * Creates a new {@code Keys} instance with randomly generated public, private, and modulus keys.
     *
     * @return A new {@code Keys} object containing the generated RSA keys.
     */
    public static Keys of() {
        var keys = generateKeys();
        return new Keys(keys.get(0), keys.get(1), keys.get(2));
    }

    /**
     * Generates RSA encryption keys by selecting two random prime numbers from a predefined list and calculating the
     * public key, private key, and modulus.
     *
     * @return A list containing the public key, private key, and modulus as {@code BigInteger} values.
     * @throws IllegalArgumentException If a relatively prime number cannot be found.
     */
    static List<BigInteger> generateKeys() {
        var primeNumbers = GeneratePrimeNumbers.generate(500);
        var p = primeNumbers.get(new Random().nextInt(0, primeNumbers.size()));
        var q = primeNumbers.get(new Random().nextInt(0, primeNumbers.size()));
        var key2 = BigInteger.valueOf(p).multiply(BigInteger.valueOf(q));
        var funEuler = BigInteger.valueOf(p - 1).multiply(BigInteger.valueOf(q - 1));
        var publicKey = findRelativelyPrimeNumber(funEuler, primeNumbers);
        var privateKey = publicKey.modInverse(funEuler);
        return new ArrayList<>(List.of(publicKey, privateKey, key2));
    }

    /**
     * Finds a number from the list of prime numbers that is relatively prime to Euler's Totient function (funEuler).
     *
     * @param funEuler     Euler's Totient function value derived from two prime numbers.
     * @param primeNumbers The list of prime numbers used to find the relatively prime number.
     * @return A relatively prime number to {@code funEuler} as a {@code BigInteger}.
     * @throws IllegalArgumentException If a relatively prime number cannot be found.
     */
    private static BigInteger findRelativelyPrimeNumber(BigInteger funEuler, List<Integer> primeNumbers) {
        for (var x : primeNumbers) {
            if (funEuler.remainder(BigInteger.valueOf(x)).compareTo(BigInteger.ZERO) > 0) {
                return BigInteger.valueOf(x);
            }
        }
        throw new IllegalArgumentException("Could not find a relatively prime number!");
    }
}