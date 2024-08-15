package com.app.numbers.position_systems;

/**
 * The Binary class provides methods for converting between binary and decimal number systems.
 * It implements the {@code PositionSystems} interface and supports both conversions:
 * binary to decimal and decimal to binary.
 */
public class Binary implements PositionSystems {

    /**
     * Converts a binary string into its decimal integer equivalent.
     *
     * @param binary A string representing a binary number, consisting only of '0' and '1'.
     * @return The decimal integer equivalent of the binary number.
     * @throws IllegalArgumentException if the binary string is null, empty, or contains characters other than '0' and '1'.
     */
    @Override
    public int changeToDecimal(String binary) {

        if (binary == null) {
            throw new IllegalArgumentException("Binary number is null");
        }

        if (binary.isEmpty()) {
            throw new IllegalArgumentException("Binary number is empty");
        }

        if (!binary.matches("[01]+")) {
            throw new IllegalArgumentException("Binary number is invalid");
        }

        var decimal = 0;
        var size = binary.length() - 1;

        for (var number : binary.toCharArray()) {
            decimal += Character.getNumericValue(number) * (int) Math.pow(2, size);
            size--;
        }

        return decimal;
    }

    /**
     * Converts a decimal integer into its binary string representation.
     *
     * @param decimalNumber A non-negative integer to be converted into binary.
     * @return A string representing the binary equivalent of the decimal number.
     * @throws IllegalArgumentException if the decimal number is negative.
     */
    @Override
    public String changeToSystem(int decimalNumber) {

        if (decimalNumber < 0) {
            throw new IllegalArgumentException("Decimal number is negative");
        }

        if (decimalNumber == 0) {
            return "0";
        }

        var binary = new StringBuilder();

        while (decimalNumber > 0) {
            binary.append(decimalNumber % 2);
            decimalNumber /= 2;
        }

        return binary.reverse().toString();
    }
}
