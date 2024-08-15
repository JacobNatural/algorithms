package com.app.numbers.utility.recursion;

/**
 * A utility interface providing various recursive methods for mathematical and array operations.
 * Methods include exponentiation, and finding the maximum and minimum values in an array.
 */
public interface NumberUtilityRecursion {

    /**
     * Calculates the result of raising a base number to a given exponent using recursion.
     * This method performs exponentiation by squaring for efficiency.
     *
     * @param x        The base number.
     * @param exponent The exponent to which the base number is raised. Must be non-negative.
     * @return The result of {@code x} raised to the power of {@code exponent}.
     * @throws IllegalArgumentException If the exponent is negative.
     */
    static long exponentiation(long x, int exponent) {

        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent is negative");
        }
        if (exponent == 0) {
            return 1;
        }

        if (exponent % 2 == 1) {
            return x * exponentiation(x * x, exponent / 2);
        }

        return exponentiation(x * x, exponent / 2);
    }

    /**
     * Finds the maximum value in an array of integers using recursion.
     *
     * @param numbers The array of integers. Must not be null or empty.
     * @return The maximum value found in the array.
     * @throws IllegalArgumentException If the array is null or empty.
     */
    static int getMax(int[] numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        return getMax(numbers, 0, numbers.length - 1);
    }

    /**
     * Recursively finds the maximum value in a subarray defined by the given range.
     *
     * @param numbers   The array of integers.
     * @param beginning The start index of the subarray.
     * @param end       The end index of the subarray.
     * @return The maximum value found in the subarray.
     */
    private static int getMax(int[] numbers, int beginning, int end) {

        if (beginning == end) {
            return numbers[beginning];
        }

        var middle = (beginning + end) / 2;

        var max1 = getMax(numbers, beginning, middle);
        var max2 = getMax(numbers, middle + 1, end);

        return Math.max(max1, max2);
    }

    /**
     * Finds the minimum value in an array of integers using recursion.
     *
     * @param numbers The array of integers. Must not be null or empty.
     * @return The minimum value found in the array.
     * @throws IllegalArgumentException If the array is null or empty.
     */
    static int getMin(int[] numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        return getMin(numbers, 0, numbers.length - 1);
    }

    /**
     * Recursively finds the minimum value in a subarray defined by the given range.
     *
     * @param numbers   The array of integers.
     * @param beginning The start index of the subarray.
     * @param end       The end index of the subarray.
     * @return The minimum value found in the subarray.
     */
    private static int getMin(int[] numbers, int beginning, int end) {

        if (beginning == end) {
            return numbers[beginning];
        }

        var middle = (beginning + end) / 2;

        var min1 = getMin(numbers, beginning, middle);
        var min2 = getMin(numbers, middle + 1, end);

        return Math.min(min1, min2);
    }
}
