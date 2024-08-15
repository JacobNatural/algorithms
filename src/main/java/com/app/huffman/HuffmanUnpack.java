package com.app.huffman;

import lombok.AllArgsConstructor;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The {@code HuffmanUnpack} class is responsible for decoding a binary string
 * that has been encoded using Huffman encoding. The decoding is based on the
 * Huffman code table that maps characters to their binary representation.
 */
@AllArgsConstructor
public class HuffmanUnpack {

    /**
     * The Huffman code map containing characters as keys and their binary codes as values.
     */
    private final Map<Character, String> code;

    /**
     * Static factory method to create a new HuffmanUnpack instance.
     *
     * @param code The Huffman code map that contains the characters and their binary codes.
     * @return A new HuffmanUnpack instance.
     * @throws IllegalArgumentException If the code map is null or empty.
     */
    public static HuffmanUnpack of(Map<Character, String> code) {
        if (code == null) {
            throw new IllegalArgumentException("Code map is null");
        }
        if (code.isEmpty()) {
            throw new IllegalArgumentException("Code map is empty");
        }
        return new HuffmanUnpack(new LinkedHashMap<>(code));
    }

    /**
     * Unpacks the binary string back into the original text using the Huffman code map.
     * The method replaces the binary sequences with their corresponding characters.
     *
     * @param binaryCode The binary string to be decoded.
     * @return The decoded text represented by the binary string.
     * @throws IllegalArgumentException If the binary code is null, empty, or contains invalid characters.
     */
    public String unpack(String binaryCode) {
        if (binaryCode == null) {
            throw new IllegalArgumentException("Binary code is null");
        }
        if (binaryCode.isEmpty()) {
            throw new IllegalArgumentException("Binary code is empty");
        }
        if (!binaryCode.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid binary code");
        }

        // Sort the code map based on binary values to ensure proper decoding.
        var sortedMap = code
                .entrySet()
                .stream()
                .sorted((map1, map2) -> map1.getValue().compareTo(map2.getValue()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // Replace the binary sequences with their corresponding characters.
        for (var entry : sortedMap) {
            binaryCode = binaryCode.replaceAll(entry.getValue(), String.valueOf(entry.getKey()));
        }

        return binaryCode;
    }
}
