package com.app.cipher.replacement_cipher;

import com.app.cipher.EncryptionService;
import lombok.NoArgsConstructor;

/**
 * The type Replacement cipher.
 */
@NoArgsConstructor
public class ReplacementCipher implements EncryptionService {
    public String encrypt(String txt){

        if(txt == null){
            throw new IllegalArgumentException("Text is null");
        }

        if(txt.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }

        var encrypt = new StringBuilder();

        for(int i = 0; i < txt.length() - 1; i += 2){
            encrypt.append(txt.charAt(i + 1)).append(txt.charAt(i));
        }

        if(txt.length() % 2 != 0){
            encrypt.append(txt.charAt(txt.length() - 1));
        }

        return encrypt.toString();
    }

    public String decrypt(String txt){
        return encrypt(txt);
    }
}
