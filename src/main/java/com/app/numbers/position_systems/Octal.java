package com.app.numbers.position_systems;

/**
 * The Octal class provides methods for converting between octal and decimal number systems.
 * It implements the {@code PositionSystems} interface and supports both conversions:
 * octal to decimal and decimal to octal.
 */
public class Octal implements PositionSystems {

    /**
     * Converts an octal string to its decimal integer equivalent.
     *
     * @param octalNumber A string representing an octal number, consisting of digits '0'-'7'.
     * @return The decimal integer equivalent of the octal number.
     * @throws IllegalArgumentException if the octal string is null, empty, or contains invalid characters.
     */
    @Override
    public int changeToDecimal(String octalNumber) {

        if (octalNumber == null) {
            throw new IllegalArgumentException("Octal number is null");
        }

        if (octalNumber.isEmpty()) {
            throw new IllegalArgumentException("Octal number is empty");
        }

        if (!octalNumber.matches("[0-7]+")) {
            throw new IllegalArgumentException("Octal number is invalid");
        }

        var decimal = 0;
        var size = octalNumber.length() - 1;

        for (var number : octalNumber.toCharArray()) {
            decimal += Character.getNumericValue(number) * (int) Math.pow(8, size);
            size--;
        }

        return decimal;
    }

    /**
     * Converts a decimal integer to its octal string representation.
     *
     * @param number A non-negative integer to be converted into octal.
     * @return A string representing the octal equivalent of the decimal number.
     * @throws IllegalArgumentException if the decimal number is negative.
     */
    @Override
    public String changeToSystem(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Octal number is negative");
        }

        if (number == 0) {
            return "0";
        }

        var octal = new StringBuilder();

        while (number > 0) {
            octal.append(number % 8);
            number /= 8;
        }

        return octal.reverse().toString();
    }
}
