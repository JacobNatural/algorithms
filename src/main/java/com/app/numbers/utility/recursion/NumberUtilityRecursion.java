package com.app.numbers.utility.recursion;

/**
 * The interface Number utility recursion.
 */
public interface NumberUtilityRecursion {

    /**
     * Exponentiation int.
     *
     * @param x        the x
     * @param exponent the exponent
     * @return the int
     */
    static long exponentiation(long x, int exponent){

        if(exponent < 0){
            throw new IllegalArgumentException("Exponent is negative");
        }
        if(exponent == 0){
            return 1;
        }

        if(exponent % 2 == 1){
            return x * exponentiation(x * x, exponent / 2 );
        }

        return exponentiation(x * x, exponent / 2);
    }

    /**
     * Get max int.
     *
     * @param numbers the numbers
     * @return the int
     */
    static int getMax(int[] numbers){

        if(numbers == null){
            throw new IllegalArgumentException("Array is null");
        }
        if(numbers.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }

        return getMax(numbers, 0, numbers.length - 1);
    }

    private static int getMax(int[] numbers, int beginning, int end) {

        if (beginning == end) {
            return numbers[beginning];
        }

        var middel = (beginning + end) / 2;

        var max1 = getMax(numbers, beginning, middel);
        var max2 = getMax(numbers, middel + 1, end);

        return Math.max(max1, max2);
    }

    /**
     * Get min int.
     *
     * @param numbers the numbers
     * @return the int
     */
    static int getMin(int[] numbers){

        if(numbers == null){
            throw new IllegalArgumentException("Array is null");
        }
        if(numbers.length == 0){
            throw new IllegalArgumentException("Array is empty");
        }

        return getMin(numbers, 0, numbers.length - 1);
    }

    private static int getMin(int[] numbers, int begining, int end) {

        if (begining == end) {
            return numbers[begining];
        }

        var middle = (begining + end) / 2;

        var max1 = getMin(numbers, begining, middle);
        var max2 = getMin(numbers, middle + 1, end);

        return Math.min(max1, max2);
    }
}
