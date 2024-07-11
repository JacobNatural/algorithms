package com.app.huffman;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * The type Huffman unpack.
 */
@AllArgsConstructor
public class HuffmanUnpack {
    private final Map<Character, String> code;


    /**
     * Of huffman unpack.
     *
     * @param code the code
     * @return the huffman unpack
     */
    public static HuffmanUnpack of(Map<Character, String> code){

        if(code == null){
            throw new IllegalArgumentException("Code map is null");
        }

        if(code.isEmpty()){
            throw new IllegalArgumentException("Code map is empty");
        }

        return new HuffmanUnpack(new LinkedHashMap<>(code));
    }

    /**
     * Unpack string.
     *
     * @param binaryCode the binary code
     * @return the string
     */
    public String unpack(String binaryCode) {

        if(binaryCode == null){
            throw new IllegalArgumentException("Binary code is null");
        }

        if(binaryCode.isEmpty()){
            throw new IllegalArgumentException("Binary code is empty");
        }

        if (!binaryCode.matches("[01]+")) {
            throw new IllegalArgumentException("Invalid binary code");
        }
        System.out.println(code);

        var sortedMap = code
                .entrySet()
                .stream()
                .sorted((map1, map2) -> ( map1.getValue().compareTo(map2.getValue())))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for(var s: sortedMap){
            System.out.println(s.getValue() + " " + s.getKey());
            binaryCode = binaryCode.replaceAll(s.getValue(), String.valueOf(s.getKey()));
        }
        return binaryCode;

    }
}
