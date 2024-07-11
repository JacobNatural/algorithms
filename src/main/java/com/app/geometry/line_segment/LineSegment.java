package com.app.geometry.line_segment;
import com.app.geometry.point.Point;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The type Line segment.
 */
@AllArgsConstructor
public class LineSegment {
    private final Point a;
    private final Point b;

    /**
     * Whether two segments intersect boolean.
     *
     * @param lineSegment the line segment
     * @return the boolean
     */
    public boolean whetherTwoSegmentsIntersect(LineSegment lineSegment) {

        if (lineSegment == null) {
            throw new IllegalArgumentException("Line segment is null");
        }

        var vec1 = a.vector(b);
        var vec2 = a.vector(lineSegment.a);
        var vec3 = lineSegment.a.vector(lineSegment.b);
        var vec4 = lineSegment.a.vector(a);

        var cross1 = vec1.crossProduct(vec2);
        var cross2 = vec3.crossProduct(vec4);

        return cross1 * cross2 < 0;
    }

    /**
     * Point is on line boolean.
     *
     * @param point the point
     * @return the boolean
     */
    public boolean pointIsOnLine(Point point) {

        if (point == null) {
            throw new IllegalArgumentException("Point is null");
        }

        Point vec1 = point.vector(a);
        Point vec2 = b.vector(a);

        double crossProduct = vec1.crossProduct(vec2);
        double epsilon = 1e-10;

        return Math.abs(crossProduct) < epsilon;
    }
}
