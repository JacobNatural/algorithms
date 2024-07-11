package com.app.cipher;

/**
 * The interface Crypter.
 */
public interface EncryptionService {
    /**
     * Encrypt string.
     *
     * @param text the text
     * @return the string
     */
    String encrypt(String text);

    /**
     * Decrypt string.
     *
     * @param text the text
     * @return the string
     */
    String decrypt(String text);

}
