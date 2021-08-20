package Shapes;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Point {
    // constructors
    private double x;
    private double y;

    /**
     * This is a function how build a now point.
     *
     * @param y double
     * @param x double
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This is a function how returnsthe distance
     * of two points.
     *
     * @param other shapes.Point
     * @return double
     */
    public double distance(Point other) {
        double finalX = (this.x - other.x) * (this.x - other.x);
        double finalY = (this.y - other.y) * (this.y - other.y);
        return Math.sqrt(finalX + finalY);
    }

    /**
     * This is a function how checks if this point
     * is tha same as the other.
     *
     * @param other shapes.Point
     * @return boolean
     */
    public boolean equals(Point other) {
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }

    /**
     * This is a function how returns the X of this point.
     *
     * @return double
     */
    public double getX() {
        return this.x;
    }

    /**
     * This is a function how return the Y of this point.
     *
     * @return double
     */
    public double getY() {
        return this.y;
    }

}
