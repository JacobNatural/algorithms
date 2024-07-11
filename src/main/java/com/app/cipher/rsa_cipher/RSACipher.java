package com.app.cipher.rsa_cipher;

import com.app.cipher.EncryptionService;
import lombok.AllArgsConstructor;

import java.math.BigInteger;
import java.util.*;

/**
 * The type Rsa cipher.
 */
@AllArgsConstructor
public class RSACipher implements EncryptionService {

    private final Keys keys;

    /**
     * Of rsa cipher.
     *
     * @return the rsa cipher
     */
    public static RSACipher of(){
       return new RSACipher(Keys.of());
    }

    public String encrypt(String text){

        if(text == null){
            throw new IllegalArgumentException("Text is null");
        }
        if(text.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }

        var crypted = new StringJoiner("\n");

        for(var sign : text.toCharArray()){
            var bigInteger = new BigInteger(String.valueOf((int)sign));
            bigInteger = bigInteger.pow(keys.publicKey.intValue()).remainder(keys.key2);
            crypted.add( bigInteger.toString());
        }
        return crypted.toString();
    }

    public String decrypt(String text){

        if(text == null){
            throw new IllegalArgumentException("Text is null");
        }
        if(text.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }
        if(!text.matches("([0-9]+\n)+([0-9]+)")){
            throw new IllegalArgumentException("Format of crypted text is not valid!");
        }

        var decrypted = new StringBuilder();

        for(var sign : text.split("\n")){

            var number = new BigInteger(sign);
            var a =  (char)  Integer.parseInt(
                   String.valueOf(
                           number.pow(keys.privateKey.intValue()).remainder(keys.key2)
                   )
           );
           decrypted.append(a);
        }
        return decrypted.toString();
    }
}



