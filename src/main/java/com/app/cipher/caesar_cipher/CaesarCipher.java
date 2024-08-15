package com.app.cipher.caesar_cipher;

import com.app.cipher.EncryptionService;
import lombok.AllArgsConstructor;

/**
 * Implementation of the Caesar Cipher encryption and decryption.
 * The Caesar Cipher is a substitution cipher where each character in the plaintext is shifted
 * a certain number of places down or up the alphabet.
 *
 * <p>It supports characters from the ASCII printable range, from '!' (33) to '~' (127).
 * Characters outside this range are not encrypted or decrypted and are kept as is.</p>
 *
 * This class uses a fixed range of printable ASCII characters and a key to perform the shift.
 */
@AllArgsConstructor
public class CaesarCipher implements EncryptionService {

    private final int key;
    private static final int MIN_COD = 33; // ASCII value of '!'
    private static final int MAX_COD = 127; // ASCII value of '~'

    /**
     * Encrypts the given text using the Caesar Cipher technique.
     *
     * @param txt the text to be encrypted
     * @return the encrypted text
     * @throws IllegalArgumentException if the input text is null or empty
     */
    public String encrypt(String txt) {
        if (txt == null) {
            throw new IllegalArgumentException("Text is null");
        }
        if (txt.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        var encrypted = new StringBuilder();
        var amount = MAX_COD - MIN_COD;

        for (var sign : txt.toCharArray()) {
            if (sign < '!' || sign > '~') {
                encrypted.append(sign);
            } else {
                var signtmp = (sign + (key % amount));
                if (signtmp >= MAX_COD) {
                    signtmp = signtmp - amount;
                }
                encrypted.append((char) signtmp);
            }
        }
        return encrypted.toString();
    }

    /**
     * Decrypts the given text that was encrypted using the Caesar Cipher technique.
     *
     * @param txt the text to be decrypted
     * @return the decrypted text
     * @throws IllegalArgumentException if the input text is null or empty
     */
    public String decrypt(String txt) {
        if (txt == null) {
            throw new IllegalArgumentException("Text is null");
        }
        if (txt.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        var decrypted = new StringBuilder();
        var amount = MAX_COD - MIN_COD;

        for (var sign : txt.toCharArray()) {
            if (sign < '!' || sign > '~') {
                decrypted.append(sign);
            } else {
                var signtmp = sign - (key % amount);
                if (signtmp < MIN_COD) {
                    signtmp = signtmp + amount;
                }
                decrypted.append((char) signtmp);
            }
        }
        return decrypted.toString();
    }
}