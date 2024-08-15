package com.app.numbers.utility.iteration;

/**
 * A utility interface providing various mathematical and array manipulation methods.
 * All methods use iterative techniques for computation.
 */
public interface NumberUtilityIteration {

    /**
     * Calculates the result of raising a base number to a given exponent using exponentiation by squaring.
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

        long result = 1L;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= x;
            }

            exponent /= 2;
            x = x * x;
        }
        return result;
    }

    /**
     * Checks if a number is a perfect number.
     * A perfect number is a positive integer that is equal to the sum of its proper divisors.
     *
     * @param number The number to be checked. Must be greater than or equal to 6.
     * @return {@code true} if {@code number} is a perfect number, otherwise {@code false}.
     * @throws IllegalArgumentException If the number is less than 6.
     */
    static boolean isPerfect(long number) {

        if (number < 6) {
            return false;
        }

        long sum = 1L;

        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i + number / i;
            }
        }

        return sum == number;
    }

    /**
     * Checks if a number is a prime number.
     * A prime number is a positive integer greater than 1 that has no positive integer divisors other than 1 and itself.
     *
     * @param number The number to be checked. Must be a non-negative integer.
     * @return {@code true} if {@code number} is a prime number, otherwise {@code false}.
     */
    static boolean isPrime(int number) {

        if (number < 2) {
            return false;
        }

        if (number == 2 || number == 3) {
            return true;
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Calculates the square root of a number using the iterative method of averaging.
     *
     * @param number  The number to find the square root of. Must be positive.
     * @param epsilon The acceptable error margin for the result. Must be between 0 and 1 (exclusive).
     * @return The approximate square root of {@code number}.
     * @throws IllegalArgumentException If {@code number} is less than or equal to 0, or {@code epsilon} is not in the range (0, 1).
     */
    static double squareRoot(double number, double epsilon) {

        if (number <= 0) {
            throw new IllegalArgumentException("Number is invalid");
        }
        if (epsilon <= 0 || epsilon >= 1) {
            throw new IllegalArgumentException("Epsilon is invalid");
        }

        double a = number / 2.0;
        double b = number / a;

        while (Math.abs(number - (a * a)) >= epsilon) {
            a = (a + b) / 2;
            b = number / a;
        }

        return a;
    }

    /**
     * Finds the maximum value in an array of integers.
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

        int index = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[index]) {
                index = i;
            }
        }

        return numbers[index];
    }

    /**
     * Finds the minimum value in an array of integers.
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

        int index = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[index]) {
                index = i;
            }
        }

        return numbers[index];
    }
}
