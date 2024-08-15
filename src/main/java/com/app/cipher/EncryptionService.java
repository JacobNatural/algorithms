package com.app.cipher;

/**
 * The EncryptionService interface provides the contract for any encryption and decryption service.
 * Classes implementing this interface should provide concrete implementations for both encryption and decryption methods.
 */
public interface EncryptionService {

    /**
     * Encrypts the given text according to the specific encryption algorithm implemented.
     *
     * @param text the plain text to be encrypted
     * @return the encrypted version of the input text
     * @throws IllegalArgumentException if the input text is null or invalid according to the encryption algorithm
     */
    String encrypt(String text);

    /**
     * Decrypts the given text according to the specific decryption algorithm implemented.
     *
     * @param text the encrypted text to be decrypted
     * @return the decrypted (plain) version of the input text
     * @throws IllegalArgumentException if the input text is null or invalid according to the decryption algorithm
     */
    String decrypt(String text);

}