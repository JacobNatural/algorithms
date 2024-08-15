package com.app.morse_code;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * The {@code MorseCode} class provides functionality to encode text into Morse code
 * and decode Morse code back into text. It supports loading a Morse code alphabet
 * from a file and converting between the text and Morse representations.
 */
@ToString
@RequiredArgsConstructor
public class MorseCode {

    /**
     * The mapping from text characters to Morse code.
     */
    private final Map<String, String> toMorseAlphabet;

    /**
     * The mapping from Morse code to text characters.
     */
    private final Map<String, String> toAlphabet;

    /**
     * Factory method to create a {@code MorseCode} object by reading data from the provided file.
     *
     * @param filenameMorse The name of the file containing the Morse code alphabet.
     * @return A new {@code MorseCode} object initialized with the alphabet.
     * @throws IllegalArgumentException If the file name is null, empty, invalid, or the file does not exist.
     * @throws IllegalStateException    If an error occurs while reading the file.
     */
    public static MorseCode of(String filenameMorse) {
        return readData(filenameMorse);
    }

    /**
     * Reads Morse code data from a file and initializes the Morse code mappings.
     *
     * @param filename The name of the file containing the Morse code data.
     * @return A new {@code MorseCode} object with initialized mappings.
     * @throws IllegalArgumentException If the filename is null, empty, invalid, or the file does not exist.
     * @throws IllegalStateException    If an error occurs while reading the file.
     */
    private static MorseCode readData(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("Filename is null");
        }

        if (filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is empty");
        }

        if (!filename.matches("[/a-zA-Z0-9.]+")) {
            throw new IllegalArgumentException("Filename is invalid");
        }

        var path = Path.of(filename);


        try (var lines = Files.lines(path)) {
            var toMorseAlphabet = lines
                    .map(line -> line.split(" "))
                    .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
            toMorseAlphabet.put(" ", ".......");

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

        } catch (Exception e) {
            throw new IllegalArgumentException("File not exist");
        }
    }

    /**
     * Converts a given text into Morse code.
     *
     * @param txt The text to be converted into Morse code.
     * @return The Morse code representation of the text.
     * @throws IllegalArgumentException If the text is null, empty, or contains invalid characters.
     */
    public String toMorse(String txt) {
        if (txt == null) {
            throw new IllegalArgumentException("Text is null");
        }

        if (txt.isEmpty()) {
            throw new IllegalArgumentException("Text is empty");
        }

        if (!txt.matches("[A-Z0-9 ]+")) {
            throw new IllegalArgumentException("Text is invalid");
        }

        var transformed = new StringJoiner(" ");

        for (var sign : txt.toCharArray()) {
            transformed.add(toMorseAlphabet.get(String.valueOf(sign)));
        }

        return transformed.toString();
    }

    /**
     * Converts a given Morse code string into its corresponding text representation.
     *
     * @param morse The Morse code to be converted into text.
     * @return The text representation of the Morse code.
     * @throws IllegalArgumentException If the Morse code is null, empty, or contains invalid characters.
     */
    public String toAlphabet(String morse) {
        if (morse == null) {
            throw new IllegalArgumentException("Morse is null");
        }

        if (morse.isEmpty()) {
            throw new IllegalArgumentException("Morse is empty");
        }

        if (!morse.matches("[. -]+")) {
            throw new IllegalArgumentException("Morse is invalid");
        }

        var alphabet = new StringBuilder();

        for (var mors : morse.split(" ")) {
            alphabet.append(toAlphabet.get(mors));
        }
        return alphabet.toString();
    }
}