package com.app.geometry.point;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The Point class represents a point in a 2D Cartesian coordinate system.
 * It provides methods for various geometric operations like cross products,
 * vector calculations, and comparisons between points.
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Point {
    private final double x;  // The x-coordinate of the point
    private final double y;  // The y-coordinate of the point

    /**
     * Computes the cross product between this point and another point.
     * The cross product is useful in determining the relative orientation of two vectors.
     *
     * @param p The other point to compute the cross product with.
     * @return The result of the cross product.
     * @throws IllegalArgumentException if the provided point is null.
     */
    public double crossProduct(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Point is null");
        }
        return x * p.y - y * p.x;
    }

    /**
     * Multiplies the x-coordinate of this point by a given variable.
     *
     * @param x The variable to multiply with the x-coordinate.
     * @return The result of the multiplication.
     */
    public double productVariableX(double x) {
        return this.x * x;
    }

    /**
     * Multiplies the y-coordinate of this point by a given variable.
     *
     * @param y The variable to multiply with the y-coordinate.
     * @return The result of the multiplication.
     */
    public double productVariableY(double y) {
        return this.y * y;
    }

    /**
     * Compares the x-coordinate of this point with another point's x-coordinate.
     *
     * @param p The other point to compare with.
     * @return true if this point's x-coordinate is greater than the other point's x-coordinate, false otherwise.
     * @throws IllegalArgumentException if the provided point is null.
     */
    public boolean compareVariableX(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Point is null");
        }
        return x > p.x;
    }

    /**
     * Compares the y-coordinate of this point with another point's y-coordinate.
     *
     * @param p The other point to compare with.
     * @return true if this point's y-coordinate is greater than the other point's y-coordinate, false otherwise.
     * @throws IllegalArgumentException if the provided point is null.
     */
    public boolean compareVariableY(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Point is null");
        }
        return y > p.y;
    }

    /**
     * Computes the vector from this point to another point.
     * The resulting vector is the difference between the coordinates of the two points.
     *
     * @param p The other point to compute the vector to.
     * @return A new Point representing the vector from this point to the provided point.
     * @throws IllegalArgumentException if the provided point is null.
     */
    public Point vector(Point p) {
        if (p == null) {
            throw new IllegalArgumentException("Point is null");
        }
        return new Point(p.x - x, p.y - y);
    }
}