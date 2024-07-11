package com.app.huffman;

import org.junit.jupiter.params.provider.Arguments;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface HuffmanDataProvider {

    List<String> binaryCode = List.of(
            "000000100000100110000000001010100000000110000000000010000110000000000001000000000010100001001100010110010000000000000000000010001000001",
            "0000000000000100000100000000000101000000100101000100000000001101000000000000000100100010100001100000100001000000000110100000000000010000000100000011000000001000000000000001001",
            "000000000000010000000000010011010000001000000000101100110000000000100000000100000100010000001000000000000100000000000000010000100010000000100000101000011010001000000010011"
            );


static Stream<HuffmanDataModel> provideHuffmanData(){
    return Stream.of(
            new HuffmanDataModel(
                    "The moon is close to earth",
                    Map.of(binaryCode.getFirst(),
                            Map.ofEntries(
                                    new AbstractMap.SimpleEntry<>(' ', "1"),
                                    new AbstractMap.SimpleEntry<>('a',"0000000000000"),
                                    new AbstractMap.SimpleEntry<>('c',"0000000000001"),
                                    new AbstractMap.SimpleEntry<>('e',"001"),
                                    new AbstractMap.SimpleEntry<>('h',"000001"),
                                    new AbstractMap.SimpleEntry<>('i',"000000000001"),
                                    new AbstractMap.SimpleEntry<>('l',"00000000001"),
                                    new AbstractMap.SimpleEntry<>('m',"0000000001"),
                                    new AbstractMap.SimpleEntry<>('n',"000000001"),
                                    new AbstractMap.SimpleEntry<>('o',"01"),
                                    new AbstractMap.SimpleEntry<>('r',"00000001"),
                                    new AbstractMap.SimpleEntry<>('s',"00001"),
                                    new AbstractMap.SimpleEntry<>('T',"0000001"),
                                    new AbstractMap.SimpleEntry<>('t',"0001")
                            ))),
            new HuffmanDataModel(
                    "Dog is the best people friends",
                    Map.of(binaryCode.get(1),
                            Map.ofEntries(
                                    new AbstractMap.SimpleEntry<>(' ', "01"),
                                    new AbstractMap.SimpleEntry<>('b',"000000000000000"),
                                    new AbstractMap.SimpleEntry<>('d',"000000000000001"),
                                    new AbstractMap.SimpleEntry<>('D',"00000000000001"),
                                    new AbstractMap.SimpleEntry<>('e',"1"),
                                    new AbstractMap.SimpleEntry<>('f',"0000000000001"),
                                    new AbstractMap.SimpleEntry<>('g',"000000000001"),
                                    new AbstractMap.SimpleEntry<>('h',"00000000001"),
                                    new AbstractMap.SimpleEntry<>('i',"0000001"),
                                    new AbstractMap.SimpleEntry<>('l',"0000000001"),
                                    new AbstractMap.SimpleEntry<>('n',"000000001"),
                                    new AbstractMap.SimpleEntry<>('o',"000001"),
                                    new AbstractMap.SimpleEntry<>('p',"00001"),
                                    new AbstractMap.SimpleEntry<>('r',"00000001"),
                                    new AbstractMap.SimpleEntry<>('s',"001"),
                                    new AbstractMap.SimpleEntry<>('t',"0001")
                            ))
            ),
            new HuffmanDataModel(
                    "Love is everything what we have",
                    Map.of(binaryCode.get(2),
                            Map.ofEntries(
                                    new AbstractMap.SimpleEntry<>(' ', "01"),
                                    new AbstractMap.SimpleEntry<>('a',"00000001"),
                                    new AbstractMap.SimpleEntry<>('e',"1"),
                                    new AbstractMap.SimpleEntry<>('g',"00000000000000"),
                                    new AbstractMap.SimpleEntry<>('h',"0001"),
                                    new AbstractMap.SimpleEntry<>('i',"0000001"),
                                    new AbstractMap.SimpleEntry<>('L',"00000000000001"),
                                    new AbstractMap.SimpleEntry<>('n',"0000000000001"),
                                    new AbstractMap.SimpleEntry<>('o',"000000000001"),
                                    new AbstractMap.SimpleEntry<>('r',"00000000001"),
                                    new AbstractMap.SimpleEntry<>('s',"0000000001"),
                                    new AbstractMap.SimpleEntry<>('t',"000001"),
                                    new AbstractMap.SimpleEntry<>('v',"001"),
                                    new AbstractMap.SimpleEntry<>('w',"00001"),
                                    new AbstractMap.SimpleEntry<>('y',"000000001")
                            )))
    );
}
}

