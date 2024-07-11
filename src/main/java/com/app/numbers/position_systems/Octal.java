package com.app.numbers.position_systems;

/**
 * Interface for converting octal number
 */
public class Octal implements PositionSystems {
    @Override
    public int changeToDecimal(String octalNumber) {

        if(octalNumber == null){
            throw new IllegalArgumentException("Octal number is null");
        }

        if(octalNumber.isEmpty()){
            throw new IllegalArgumentException("Octal number is empty");
        }

        if(!octalNumber.matches("[0-7]+")){
            throw new IllegalArgumentException("Octal number is invalid");
        }

        var decimal = 0;
        var size = octalNumber.length() - 1;

        for(var number : octalNumber.toCharArray()){
            decimal += Character.getNumericValue(number) * (int) Math.pow(8, size);
            size--;
        }

        return decimal;
    }

    @Override
    public String changeToSystem(int number) {
        if(number < 0){
            throw new IllegalArgumentException("Octal number is negative");
        }

        if(number == 0){
            return "0";
        }

        var octal = new StringBuilder();

        while (number > 0){
            octal.append(number % 8);
            number /= 8;
        }

        return octal.reverse().toString();
    }
}
