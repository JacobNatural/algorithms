package com.app.numbers.position_systems;

/**
 * The type Binary.
 */
public class Binary implements PositionSystems{
    @Override
    public int changeToDecimal(String binary) {

        if(binary == null){
            throw new IllegalArgumentException("Binary number is null");
        }

        if(binary.isEmpty()){
            throw new IllegalArgumentException("Binary number is empty");
        }

        if(!binary.matches("[01]+")){
            throw new IllegalArgumentException("Binary number is invalid");
        }

        var decimal = 0;
        var size = binary.length() - 1;

        for(var number : binary.toCharArray()){
            decimal += Character.getNumericValue(number) * (int)Math.pow(2, size);
            size--;
        }

        return decimal;
    }

    @Override
    public String changeToSystem(int decimalNumber) {
        if(decimalNumber < 0){
            throw new IllegalArgumentException("Decimal number is negative");
        }

        if(decimalNumber == 0){
            return "0";
        }

        var binary = new StringBuilder();

        while (decimalNumber > 0){
            binary.append(decimalNumber % 2);
            decimalNumber /= 2;
        }
        return binary.reverse().toString();
    }
}
