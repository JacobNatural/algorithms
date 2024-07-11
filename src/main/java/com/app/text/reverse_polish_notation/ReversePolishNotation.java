package com.app.text.reverse_polish_notation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * The type Reverse polish notation.
 */
public class ReversePolishNotation {
    private double calculate(double a, double b, String operand){

        return switch (operand){
            case "*" -> a * b;
            case "/" -> a / b;
            case "+" -> a + b;
            case  "-" -> a - b;
            default -> throw new IllegalArgumentException("Wrong operand");
         };
    }

    /**
     * Calculate revers polish notation double.
     *
     * @param notations the notations
     * @return the double
     */
    public double calculate(String notations){

        if(notations == null){
            throw new IllegalArgumentException("Reverse polish notation is null");
        }
        if(notations.isEmpty()){
            throw new IllegalArgumentException("Reverse polish notation is empty");
        }

        if(!notations.matches("[0-9*+\\-/. ]+")){
            throw new IllegalArgumentException("Reverse polish notation is invalid");
        }

        Deque<Double> stack = new LinkedList<>();

        var split = notations.split(" ");

        for(var notation : split){
            if(notation.matches("[0-9].?[0-9]?")){
                stack.push(Double.parseDouble(notation));
            }else {

                if(stack.size() < 2){
                    throw new IllegalArgumentException("Error between numbers and operators");
                }
                var b = stack.remove();
                var a = stack.remove();
                stack.push(calculate(a,b,notation));
            }
        }

        if(stack.size() > 1){
            throw new IllegalArgumentException("Numbers is too much");
        }

        return stack.remove();
    }
}
