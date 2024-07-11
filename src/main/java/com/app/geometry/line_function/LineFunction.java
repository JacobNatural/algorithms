package com.app.geometry.line_function;

import com.app.geometry.point.Point;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The type Line function.
 */
@AllArgsConstructor
public class LineFunction {

    private final double a;
    private final double b;
    private final double c;


    /**
     * Is point on line function boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean isPointOnLineFunction(Point point){

        if(point == null){
            throw new IllegalArgumentException("Point is null");
        }

        return point.productVariableX(a) + point.productVariableY(b) + c == 0;
    }
}
