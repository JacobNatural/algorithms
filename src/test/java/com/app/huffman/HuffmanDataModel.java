package com.app.huffman;

import java.util.Map;


public record HuffmanDataModel(String text, Map<String, Map<Character,String>> data) {}
