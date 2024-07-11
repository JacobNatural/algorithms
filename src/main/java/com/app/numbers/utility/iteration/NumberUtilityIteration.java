package com.app.numbers.utility.iteration;

/**
 * A class with tools for handling numbers in iterative way
 */
public interface NumberUtilityIteration {



    /**
     * Calculating the power of a number
     * @param x the basis of power
     * @param exponent exponent
     * @return exponential number
     */

    static long exponentiation(long x, int exponent){

        if(exponent < 0){
            throw new IllegalArgumentException("Exponent is negative");
        }

        var result = 1L;

        while (exponent > 0){

            if(exponent % 2 == 1){
                result *= x;
            }

            exponent /= 2;
            x = x * x;
        }
        return result;
    }



    /**
     * Checking if is perfect number
     * @param number number for check
     * @return confirmation whether the number is a perfect number
     */

    static boolean isPerfect(long number){

        if(number < 6) {
            return false;
        }

        var sum = 1L;

        for(long i = 2; i * i <= number; i++){
            if(number % i == 0){
                sum += i + number / i;
            }
        }

        return sum == number;
    }

    /**
     * Checking if is prime number
     * @param number number for check
     * @return confirmation whether the number is a prime number
     */

    static boolean isPrime(int number){

        if(number < 2){
            return false;
        }

        if(number == 2 || number == 3){
            return true;
        }

        if(number % 2 == 0 || number % 3 == 0){
            return false;
        }

        for(int i = 5; i*i <= number; i += 6){
            if(number % i == 0 || number  % (i + 2) == 0){
                return false;
            }
        }

        return true;
    }

    /**
     * Calculating the square root using the newton raphson method
     * @param number number to calculate
     * @param epsilon precision
     * @return root square
     */

    static double rootSquare(double number, double epsilon) {

        if (number <= 0) {
            throw new IllegalArgumentException("Number is invalid");
        }
        if(epsilon <= 0 || epsilon >= 1){
            throw new IllegalArgumentException("Epsilon is invalid");
        }

        var a = number / 2.0;
        var b = number / a;

        while (Math.abs(number - (a * a)) >= epsilon){
            a = (a + b) / 2;
            b = number / a;
        }

        return a;
    }

    /**
     * Max search in a numerical sequence
     * @param numbers numerical sequence
     * @return max number
     */

    static int getMax(int[] numbers){

        if(numbers == null){
            throw new IllegalArgumentException("Array is null");
        }

        if(numbers.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }

        var  index = 0;

        for(int i = 1; i < numbers.length; i++){

            if(numbers[i] > numbers[index]){
                index = i;
            }
        }

        return numbers[index];
    }

    /**
     * Min search in a numerical sequence
     * @param numbers numercial sequence
     * @return min number
     */
    static int getMin(int[] numbers){

        if(numbers == null){
            throw new IllegalArgumentException("Array is null");
        }

        if(numbers.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }

        var index = 0;

        for(int i = 1; i < numbers.length; i++){

            if(numbers[i] < numbers[index]){
                index = i;
            }
        }

        return numbers[index];
    }
}
