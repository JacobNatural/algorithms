package com.app.morse_code;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;


/**
 * The type Morse code.
 */
@ToString
@RequiredArgsConstructor
public class MorseCode {
    private final Map<String,String> toMorseAlphabet;
    private final Map<String, String> toAlphabet;

    /**
     * Of morse code.
     *
     * @param filenameMorse the filenameMorse
     * @return the morse code
     */
    public static MorseCode of(String filenameMorse){
        return readData(filenameMorse);
    }

    private static MorseCode readData(String filename){

        if(filename == null){
            throw new IllegalArgumentException("Filename is null");
        }

        if(filename.isEmpty()){
            throw new IllegalArgumentException("Filename is empty");
        }

        if(!filename.matches("[/a-zA-Z0-9.]+")){
            throw new IllegalArgumentException("Filename is invalid");
        }
        var path = Path.of(filename);

        if(!Files.exists(path)){
            throw new IllegalArgumentException("File not exist");
        }

        try(var lines = Files.lines(path)){

           var toMorseAlphabet = lines
                    .map(line -> line.split(" "))
                    .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
           toMorseAlphabet.put(" ",".......");

            var toAlphabet = toMorseAlphabet
                    .entrySet()
                    .stream()
                    .sorted((map1, map2) -> Integer.compare(map2.getValue().length(), map1.getValue().length()))
                    .collect(Collectors.toMap(
                            Map.Entry::getValue,
                            Map.Entry::getKey,
                            (v1, v2) -> v1,
                            LinkedHashMap::new));

            return new MorseCode(toMorseAlphabet, toAlphabet);

         }catch (Exception e){
            throw new IllegalStateException();
        }
    }

    /**
     * To morse string.
     *
     * @param txt the txt
     * @return the string
     */
    public String toMorse(String txt){

        if(txt == null){
            throw new IllegalArgumentException("Text is null");
        }

        if(txt.isEmpty()){
            throw new IllegalArgumentException("Text is empty");
        }

        if(!txt.matches("[A-Z0-9 ]+")){
            throw new IllegalArgumentException("Text is invalid");
        }

        var transformed = new StringJoiner(" ");

        for(var sign : txt.toCharArray()) {
            transformed.add(toMorseAlphabet.get(String.valueOf(sign)));
        }

        return transformed.toString();
    }

    /**
     * To alphabet string.
     *
     * @param morse the morse
     * @return the string
     */
    public String toAlphabet(String morse) {

        if(morse == null){
            throw new IllegalArgumentException("Morse is null");
        }

        if(morse.isEmpty()){
            throw new IllegalArgumentException("Morse is empty");
        }

        if(!morse.matches("[. -]+")){
            throw new IllegalArgumentException("Morse is invalid");
        }

        var alphabet = new StringBuilder();

        for (var mors : morse.split(" ")) {
            alphabet.append(toAlphabet.get(mors));
        }
        return alphabet.toString();
    }
}




