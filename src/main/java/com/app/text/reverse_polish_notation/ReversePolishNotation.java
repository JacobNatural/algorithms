package com.app.text.reverse_polish_notation;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This class evaluates arithmetic expressions given in Reverse Polish Notation (RPN).
 * RPN is a mathematical notation in which every operator follows all of its operands.
 * For example, the expression "3 4 +" evaluates to 7.
 */
public class ReversePolishNotation {

    /**
     * Performs a calculation based on the provided operand and two operands.
     *
     * @param a       the first operand
     * @param b       the second operand
     * @param operand the operator to be applied
     * @return the result of the operation
     * @throws IllegalArgumentException if the operand is not one of "+", "-", "*", or "/"
     */
    private double calculate(double a, double b, String operand) {
        return switch (operand) {
            case "*" -> a * b;
            case "/" -> a / b;
            case "+" -> a + b;
            case "-" -> a - b;
            default -> throw new IllegalArgumentException("Wrong operand");
        };
    }

    /**
     * Evaluates the given expression in Reverse Polish Notation.
     *
     * @param notations a string representing an arithmetic expression in RPN
     * @return the result of the evaluated expression
     * @throws IllegalArgumentException if the input string is null, empty, contains invalid characters,
     *                                  or if there are incorrect numbers of operands and operators
     */
    public double calculate(String notations) {
        if (notations == null) {
            throw new IllegalArgumentException("Reverse polish notation is null");
        }
        if (notations.isEmpty()) {
            throw new IllegalArgumentException("Reverse polish notation is empty");
        }
        if (!notations.matches("[0-9*+\\-/. ]+")) {
            throw new IllegalArgumentException("Reverse polish notation is invalid");
        }

        Deque<Double> stack = new LinkedList<>();
        var split = notations.split(" ");

        for (var notation : split) {
            if (notation.matches("[0-9]*\\.?[0-9]+")) {  // Adjusted regex to handle decimals more accurately
                stack.push(Double.parseDouble(notation));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Error between numbers and operators");
                }
                var b = stack.pop();
                var a = stack.pop();
                stack.push(calculate(a, b, notation));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Numbers is too much");
        }

        return stack.pop();
    }
}
