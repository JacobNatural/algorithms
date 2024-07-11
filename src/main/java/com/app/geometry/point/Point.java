package com.app.geometry.point;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The type Point.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Point {
    private final double x;
    private final double y;


    /**
     * Product double.
     *
     * @param p the p
     * @return the double
     */
    public double crossProduct(Point p){
        if(p == null){
            throw new IllegalArgumentException("Point is null");
        }
        return x * p.y - y * p.x;
    }

    /**
     * Product variable x double.
     *
     * @param x the x
     * @return the double
     */
    public double productVariableX(double x){
        return this.x * x;
    }

    /**
     * Product variable y double.
     *
     * @param y the y
     * @return the double
     */
    public double productVariableY(double y){
        return this.y * y;
    }

    /**
     * Compare variable x boolean.
     *
     * @param p the p
     * @return the boolean
     */
    public boolean compareVariableX(Point p ){
        if(p == null){
            throw new IllegalArgumentException("Point is null");
        }
        return x > p.x;
    }

    /**
     * Compare variable y boolean.
     *
     * @param p the p
     * @return the boolean
     */
    public boolean compareVariableY(Point p ){

        if(p == null){
            throw new IllegalArgumentException("Point is null");
        }
        return y > p.y;
    }


    /**
     * Vector point.
     *
     * @param p the p
     * @return the point
     */
    public Point vector(Point p){
        if(p == null){
            throw new IllegalArgumentException("Point is null");
        }
        return new Point(p.x - x, p.y - y);
    }

}
