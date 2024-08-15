package com.app.cipher.rsa_cipher;

import com.app.cipher.EncryptionService;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.*;

/**
 * The {@code RSACipher} class implements the RSA encryption and decryption algorithm.
 * It uses {@code Keys} to handle the public, private, and modulus values necessary for the RSA operations.
 */
@AllArgsConstructor
public class RSACipher implements EncryptionService {

    /**
     * The RSA keys used for encryption and decryption.
     */
    private final Keys keys;

    /**
     * Creates a new {@code RSACipher} instance with freshly generated RSA keys.
     *
     * @return A new {@code RSACipher} object.
     */
    public static RSACipher of() {
        return new RSACipher(Keys.of());
    }

    /**
     * Encrypts the given plain text using the RSA encryption algorithm.
     * The plain text is converted to its ASCII values, then encrypted using the public key and modulus.
     * Each encrypted value is stored as a string, separated by newline characters.
     *
     * @param text The plain text to be encrypted.
     * @return The encrypted text, with each encrypted character represented by a number and separated by newlines.
     * @throws IllegalArgumentException If the input text is null or empty.
     */
    @Override
    public String encrypt(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        var crypted = new StringJoiner("\n");

        for (var sign : text.toCharArray()) {
            var bigInteger = new BigInteger(String.valueOf((int) sign));
            bigInteger = bigInteger.pow(keys.publicKey.intValue()).remainder(keys.key2);
            crypted.add(bigInteger.toString());
        }
        return crypted.toString();
    }

    /**
     * Decrypts the given encrypted text using the RSA decryption algorithm.
     * The encrypted text should be formatted as numbers separated by newlines, corresponding to the encrypted ASCII values.
     *
     * @param text The encrypted text to be decrypted.
     * @return The decrypted plain text.
     * @throws IllegalArgumentException If the input text is null, empty, or not in the expected format.
     */
    @Override
    public String decrypt(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text is null");
        }
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }
        if (!text.matches("([0-9]+\n)+([0-9]+)")) {
            throw new IllegalArgumentException("Format of encrypted text is not valid!");
        }

        var decrypted = new StringBuilder();

        for (var sign : text.split("\n")) {
            var number = new BigInteger(sign);
            var a = (char) Integer.parseInt(
                    String.valueOf(
                            number.pow(keys.privateKey.intValue()).remainder(keys.key2)
                    )
            );
            decrypted.append(a);
        }
        return decrypted.toString();
    }
}