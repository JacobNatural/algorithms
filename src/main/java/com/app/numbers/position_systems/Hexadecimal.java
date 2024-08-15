package com.app.numbers.position_systems;

import java.util.Locale;

/**
 * The Hexadecimal class provides methods for converting between hexadecimal and decimal number systems.
 * It implements the {@code PositionSystems} interface and supports both conversions:
 * hexadecimal to decimal and decimal to hexadecimal.
 */
public class Hexadecimal implements PositionSystems {

    /**
     * Converts a hexadecimal string to its decimal integer equivalent.
     *
     * @param hexadecimal A string representing a hexadecimal number, consisting of '0'-'9', 'a'-'f', or 'A'-'F'.
     * @return The decimal integer equivalent of the hexadecimal number.
     * @throws IllegalArgumentException if the hexadecimal string is null, empty, or contains invalid characters.
     */
    @Override
    public int changeToDecimal(String hexadecimal) {

        if (hexadecimal == null) {
            throw new IllegalArgumentException("Hexadecimal is null");
        }

        if (hexadecimal.isEmpty()) {
            throw new IllegalArgumentException("Hexadecimal is empty");
        }

        if (!hexadecimal.matches("[0-9a-fA-F]+")) {
            throw new IllegalArgumentException("Hexadecimal is invalid");
        }

        var decimal = 0;
        var size = hexadecimal.length() - 1;

        for (var number : hexadecimal.toCharArray()) {
            decimal += hexToDecimalHelper(String.valueOf(number)) * (int) Math.pow(16, size);
            size--;
        }

        return decimal;
    }

    /**
     * Converts a decimal integer to its hexadecimal string representation.
     *
     * @param numberDecimal A non-negative integer to be converted into hexadecimal.
     * @return A string representing the hexadecimal equivalent of the decimal number.
     * @throws IllegalArgumentException if the decimal number is negative.
     */
    @Override
    public String changeToSystem(int numberDecimal) {

        if (numberDecimal < 0) {
            throw new IllegalArgumentException("Decimal number is negative");
        }

        if (numberDecimal == 0) {
            return "0";
        }

        var hexadecimal = new StringBuilder();

        while (numberDecimal > 0) {
            hexadecimal.append(decimalToHexHelper(numberDecimal % 16));
            numberDecimal /= 16;
        }

        return hexadecimal.reverse().toString();
    }

    /**
     * Helper method to convert a single hexadecimal character to its decimal equivalent.
     *
     * @param number A string containing a single hexadecimal character.
     * @return The decimal equivalent of the hexadecimal character.
     */
    private static int hexToDecimalHelper(String number) {

        if (number.matches("[a-fA-F]")) {
            return HexHelper.hexToDecimal.get(number.toUpperCase(Locale.ROOT));
        }

        return Integer.parseInt(number);
    }

    /**
     * Helper method to convert a decimal number (0-15) to its hexadecimal string equivalent.
     *
     * @param number The decimal number (0-15).
     * @return The hexadecimal string equivalent of the decimal number.
     */
    private static String decimalToHexHelper(int number) {
        if (number > 9) {
            return HexHelper.decimalToHex.get(number);
        }
        return String.valueOf(number);
    }
}
