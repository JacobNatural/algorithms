package com.app.geometry.line_function;

import com.app.geometry.point.Point;
import lombok.AllArgsConstructor;

/**
 * The LineFunction class represents a linear function of the form ax + by + c = 0.
 * It provides functionality to check whether a given point lies on the line defined by the function.
 */
@AllArgsConstructor
public class LineFunction {

    private final double a;  // Coefficient for x
    private final double b;  // Coefficient for y
    private final double c;  // Constant term

    /**
     * Checks if a given point lies on the line represented by the linear function ax + by + c = 0.
     *
     * @param point The point to be checked.
     * @return true if the point lies on the line, false otherwise.
     * @throws IllegalArgumentException if the point is null.
     */
    public boolean isPointOnLineFunction(Point point) {

        if (point == null) {
            throw new IllegalArgumentException("Point is null");
        }

        // Check if the point satisfies the equation ax + by + c = 0
        return point.productVariableX(a) + point.productVariableY(b) + c == 0;
    }
}