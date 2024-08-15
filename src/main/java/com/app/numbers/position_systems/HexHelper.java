package com.app.numbers.position_systems;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * The HexHelper class provides static mappings for converting between decimal and hexadecimal values.
 * This class cannot be instantiated, and its purpose is to assist in hexadecimal-decimal conversions.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HexHelper {

    /**
     * A map that converts decimal values (10-15) to their corresponding hexadecimal characters ('A'-'F').
     */
    static final Map<Integer, String> decimalToHex = Map.of(
            10, "A",
            11, "B",
            12, "C",
            13, "D",
            14, "E",
            15, "F");

    /**
     * A map that converts hexadecimal characters ('A'-'F') to their corresponding decimal values (10-15).
     */
    static final Map<String, Integer> hexToDecimal = Map.of(
            "A", 10,
            "B", 11,
            "C", 12,
            "D", 13,
            "E", 14,
            "F", 15);
}