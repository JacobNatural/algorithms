package com.app.numbers.position_systems;

/**
 * The PositionSystems interface defines methods for converting between a positional
 * number system (e.g., binary, octal, hexadecimal) and the decimal system.
 * Implementing classes are responsible for providing the conversion logic for a specific
 * positional system.
 */
public interface PositionSystems {

    /**
     * Converts a number from a specific positional system to its decimal integer equivalent.
     *
     * @param number A string representing a number in the specific positional system.
     * @return The decimal integer equivalent of the input number.
     * @throws IllegalArgumentException if the input number is invalid according to the positional system's rules.
     */
    int changeToDecimal(String number);

    /**
     * Converts a decimal integer into its equivalent representation in the specific positional system.
     *
     * @param number A non-negative integer to be converted into the specific positional system.
     * @return A string representing the number in the specific positional system.
     * @throws IllegalArgumentException if the input number is negative.
     */
    String changeToSystem(int number);
}
