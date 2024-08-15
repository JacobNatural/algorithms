package com.app.cipher.replacement_cipher;

import com.app.cipher.EncryptionService;
import lombok.NoArgsConstructor;

/**
 * The ReplacementCipher class provides an implementation of a simple replacement cipher.
 * The cipher works by swapping adjacent characters in the input text.
 *
 * <p>If the length of the input text is odd, the last character remains unchanged during encryption.</p>
 *
 * This cipher is symmetric, meaning that the same method can be used for both encryption and decryption.
 */
@NoArgsConstructor
public class ReplacementCipher implements EncryptionService {

    /**
     * Encrypts the given text by swapping adjacent characters.
     * If the text length is odd, the last character remains in place.
     *
     * @param txt the text to be encrypted
     * @return the encrypted text with adjacent characters swapped
     * @throws IllegalArgumentException if the input text is null or empty
     */
    public String encrypt(String txt) {
        if (txt == null) {
            throw new IllegalArgumentException("Text is null");
        }
        if (txt.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        var encrypt = new StringBuilder();

        // Swap adjacent characters in the text
        for (int i = 0; i < txt.length() - 1; i += 2) {
            encrypt.append(txt.charAt(i + 1)).append(txt.charAt(i));
        }

        // If the text length is odd, add the last character unchanged
        if (txt.length() % 2 != 0) {
            encrypt.append(txt.charAt(txt.length() - 1));
        }

        return encrypt.toString();
    }

    /**
     * Decrypts the given text using the same logic as encryption, since the cipher is symmetric.
     *
     * @param txt the text to be decrypted
     * @return the decrypted text with adjacent characters swapped back
     * @throws IllegalArgumentException if the input text is null or empty
     */
    public String decrypt(String txt) {
        return encrypt(txt);  // Symmetric cipher: encryption logic is used for decryption
    }
}