package com.app.geometry.line_segment;

import com.app.geometry.point.Point;
import lombok.AllArgsConstructor;

/**
 * The LineSegment class represents a line segment in 2D space defined by two points, a and b.
 * It provides methods to check if two line segments intersect and if a point lies on the line segment.
 */
@AllArgsConstructor
public class LineSegment {

    private final Point a;  // One endpoint of the line segment
    private final Point b;  // The other endpoint of the line segment

    /**
     * Determines whether two line segments intersect.
     * This method uses the cross product to check the relative orientation of the segments.
     *
     * @param lineSegment The other line segment to check intersection with.
     * @return true if the two line segments intersect, false otherwise.
     * @throws IllegalArgumentException if the provided line segment is null.
     */
    public boolean whetherTwoSegmentsIntersect(LineSegment lineSegment) {

        if (lineSegment == null) {
            throw new IllegalArgumentException("Line segment is null");
        }

        // Calculate vectors between points
        var vec1 = a.vector(b);
        var vec2 = a.vector(lineSegment.a);
        var vec3 = lineSegment.a.vector(lineSegment.b);
        var vec4 = lineSegment.a.vector(a);

        // Compute cross products
        var cross1 = vec1.crossProduct(vec2);
        var cross2 = vec3.crossProduct(vec4);

        // Determine intersection based on the sign of the cross products
        return cross1 * cross2 < 0;
    }

    /**
     * Checks whether a given point lies on the line segment.
     * This method uses the cross product to verify if the point is collinear with the segment's endpoints.
     *
     * @param point The point to check.
     * @return true if the point lies on the line segment, false otherwise.
     * @throws IllegalArgumentException if the provided point is null.
     */
    public boolean pointIsOnLine(Point point) {

        if (point == null) {
            throw new IllegalArgumentException("Point is null");
        }

        // Calculate vectors from the point to one endpoint and between both endpoints
        Point vec1 = point.vector(a);
        Point vec2 = b.vector(a);

        // Compute cross product
        double crossProduct = vec1.crossProduct(vec2);
        double epsilon = 1e-10;

        // Check if the cross product is close to zero (collinear)
        return Math.abs(crossProduct) < epsilon;
    }
}