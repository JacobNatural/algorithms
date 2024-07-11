package com.app.numbers.position_systems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Class with data for hexadecimal convert
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HexHelper {

     static final Map<Integer,String> decimalToHex = Map.of(
            10,"A", 11, "B", 12, "C", 13, "D", 14, "E", 15, "F");
     static final Map<String,Integer> hexToDecimal = Map.of(
            "A",10,  "B",11, "C", 12,  "D",13,  "E",14,  "F",15);
}
