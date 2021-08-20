package Shapes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * the function construct a new rectangle.
     *
     * @param upperLeft shapes.Point, the upper left point.
     * @param width     double.
     * @param height    double.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

    }

    /**
     * the function checks if there are intersections of the rectangle and the given line
     * and returns a list of all the intersection points.
     *
     * @param line shapes.Line
     * @return java.util.List<shapes.Point>
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Point upperRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
        Point lowLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
        Point lowRight = new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
        if (line.start().getX() > this.getUpperLeft().getX()
                && line.start().getY() > this.getUpperLeft().getY()
                && line.start().getX() < lowRight.getX()
                && line.start().getY() < lowRight.getY()) {
            List<Point> lists = new ArrayList<Point>();
            lists.add(0, line.start());
            return lists;
        }
        //the 4 lines of the rectangle:
        Line[] lines = new Line[4];
        lines[0] = new Line(lowLeft, lowRight);
        lines[1] = new Line(this.upperLeft, lowLeft);
        lines[2] = new Line(lowRight, upperRight);
        lines[3] = new Line(this.upperLeft, upperRight);
        List<Point> lists = new ArrayList<Point>();
        int count = 0;
        for (int i = 0; i < 4; i++) {
            // for every line in rectangle, check if there is an intersection:
            if (lines[i].intersectionWith(line) != null) {
                lists.add(count, lines[i].intersectionWith(line));
                count++;
            }
        }
        // if there are no intersections:
        if (count == 0) {
            return null;

        }
        return lists;
    }

    /**
     * the function return the width of the rectangle.
     *
     * @return double.
     */
    public double getWidth() {
        return this.width;

    }

    /**
     * the function return the width of the rectangle.
     *
     * @return double.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * the function return the upper left point of the rectangle.
     *
     * @return shapes.Point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
}