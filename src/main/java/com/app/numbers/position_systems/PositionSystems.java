package com.app.numbers.position_systems;

/**
 * The interface Position systems.
 */
public interface PositionSystems {
    /**
     * Change to decimal int.
     *
     * @param number the number
     * @return the int
     */
    int changeToDecimal(String number);

    /**
     * Change to system string.
     *
     * @param number the number
     * @return the string
     */
    String changeToSystem(int number);
}
