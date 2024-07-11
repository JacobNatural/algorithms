package com.app.cipher.caesar_cipher;

import com.app.cipher.EncryptionService;
import lombok.AllArgsConstructor;

/**
 * The type Caesar cipher.
 */
@AllArgsConstructor
public class CaesarCipher implements EncryptionService {

    private final int key;
    private static final int MIN_COD = 33;
    private static final int MAX_COD = 127;

    public String encrypt(String txt){

        if(txt == null){
            throw new IllegalArgumentException("Text is null");
        }
        if(txt.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }

        var encrypted = new StringBuilder();

        for(var sign : txt.toCharArray()) {

            if(sign < '!'|| sign > '~'){
                encrypted.append(sign);
            }else {

            var amount = MAX_COD - MIN_COD;
            var signtmp =  (sign + (key % amount));

            if(signtmp >= MAX_COD){
                signtmp =  signtmp - amount;
            }

            encrypted.append((char)signtmp);
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String txt){

        if(txt == null){
            throw new IllegalArgumentException("Text is null");
        }

        if(txt.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }

        var decrypted = new StringBuilder();
        var amount = MAX_COD - MIN_COD;

        for(var sign : txt.toCharArray()) {

            if(sign < '!'|| sign > '~'){
                decrypted.append(sign);
            }else {

                var signtmp = sign - (key % amount);

                if (signtmp < MIN_COD) {
                    signtmp = signtmp + amount;
                }
                decrypted.append((char)signtmp);
            }
        }
        return decrypted.toString();
    }
}
