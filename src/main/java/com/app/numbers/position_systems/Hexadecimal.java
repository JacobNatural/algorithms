package com.app.numbers.position_systems;

import java.util.Locale;

/**
 * Interface for converting hexadecimal numbers
 */
public class Hexadecimal implements PositionSystems{
    @Override
    public int changeToDecimal(String hexadecimal) {
        if(hexadecimal == null){
            throw new IllegalArgumentException("Hexadecimal is null");
        }

        if(hexadecimal.isEmpty()){
            throw new IllegalArgumentException("Hexadecimal is empty");
        }

        if(!hexadecimal.matches("[0-9a-fA-F]+")){
            throw new IllegalArgumentException("Hexadecimal is invalid");
        }

        var decimal = 0;
        var size = hexadecimal.length() - 1;

        for(var number : hexadecimal.toCharArray()){
            decimal += hexToDecimalHelper(String.valueOf(number)) * (int) Math.pow(16, size);
            size--;
        }

        return decimal;
    }
    private static int hexToDecimalHelper(String number){

        if(number.matches("[a-fA-F]")){
            return HexHelper.hexToDecimal.get(number.toUpperCase(Locale.ROOT));
        }

        return Integer.parseInt(number);
    }

    @Override
    public String changeToSystem(int numberDecimal) {
        if(numberDecimal < 0){
            throw new IllegalArgumentException("Decimal number is negative");
        }

        if(numberDecimal == 0){
            return "0";
        }

        var hexadecimal = new StringBuilder();

        while (numberDecimal > 0){
            hexadecimal.append(decimalToHexHelper(numberDecimal % 16));
            numberDecimal /= 16;
        }

        return hexadecimal.reverse().toString();
    }

    private static String decimalToHexHelper(int number){
        if(number > 9){
            return HexHelper.decimalToHex.get(number);
        }
        return String.valueOf(number);
    }
}
