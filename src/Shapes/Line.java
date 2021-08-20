package Shapes;

import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Line {
    // constructors
    private Point start;
    private Point end;

    /**
     * This is a function how construct a new line
     * based on start and end point.
     *
     * @param start shapes.Point
     * @param end   shapes.Point
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * This is a function how construct a new line
     * based on two X & two Y.
     *
     * @param x1 double
     * @param y1 double
     * @param x2 double
     * @param y2 double
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * This is a function how return the length of the line.
     *
     * @return double
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * This is a function how returns the middle of the line.
     *
     * @return shapes.Point
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * This is a function how returns the start of the line.
     *
     * @return shapes.Point
     */
    public Point start() {
        return this.start;
    }

    /**
     * This is a function how returns the end of the line.
     *
     * @return shapes.Point
     */
    public Point end() {
        return this.end;
    }


    /**
     * This is a function how checks if this line intersect with
     * another line, if so, returns the point of intersection,
     * else return null.
     *
     * @param other shapes.Line
     * @return shapes.Point
     */
    public Point intersectionWith(Line other) {
        double mThis, mOther, bThis, bOther;
        double interX, interY;
        double otherSX, otherSY, otherEX, otherEY, thisSX, thisSY, thisEX, thisEY;
        otherSX = other.start.getX();
        otherSY = other.start.getY();
        otherEX = other.end.getX();
        otherEY = other.end.getY();
        thisSX = this.start.getX();
        thisSY = this.start.getY();
        thisEX = this.end.getX();
        thisEY = this.end.getY();
        if ((thisSX == thisEX) && (otherSX == otherEX)) {
            return null;
        }
        if (thisSX == thisEX) {
            interX = thisSX;
            mOther = (otherSY - otherEY) / (otherSX - otherEX);
            bOther = otherSY - (otherSX * mOther);
            interY = (mOther * interX) + bOther;
        } else if (otherSX == otherEX) {
            interX = otherSX;
            mThis = (thisSY - thisEY) / (thisSX - thisEX);
            bThis = thisSY - (thisSX * mThis);
            interY = (mThis * interX) + bThis;
        } else {
            mThis = (thisSY - thisEY) / (thisSX - thisEX);
            mOther = (otherSY - otherEY) / (otherSX - otherEX);
            if (mThis == mOther) {
                return null;
            }
            bThis = thisSY - (thisSX * mThis);
            bOther = otherSY - (otherSX * mOther);
            interX = -(bThis - bOther) / (mThis - mOther);
            interY = (mThis * interX) + bThis;
        }
        if (((interX > thisSX) && (interX > thisEX))
                || ((interX < thisSX) && (interX < thisEX))
                || ((interX > otherSX) && (interX > otherEX))
                || ((interX < otherSX) && (interX < otherEX))) {
            return null;
        }
        if (((interY > thisSY) && (interY > thisEY))
                || ((interY < thisSY) && (interY < thisEY))
                || ((interY > otherSY) && (interY > otherEY))
                || ((interY < otherSY) && (interY < otherEY))) {
            return null;
        }
        Point point = new Point(interX, interY);
        return point;

    }

    /**
     * This is a function how checks if this line is equal
     * to the other line.
     *
     * @param other shapes.Line
     * @return boolean
     */
    public boolean equals(Line other) {
        if (this.start.getX() == other.start.getX()
                && this.end.getX() == other.end.getX()
                && this.start.getY() == other.start.getY()
                && this.end.getY() == other.end.getY()) {
            return true;
        }
        if (this.start.getX() == other.end.getX()
                && this.end.getX() == other.start.getX()
                && this.start.getY() == other.end.getY()
                && this.end.getY() == other.start.getY()) {
            return true;
        }
        return false;
    }


    /**
     * the function get a rectangle and return the closest intersection
     * point with this line.
     *
     * @param rect shapes.Rectangle
     * @return shapes.Point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> l = rect.intersectionPoints(this);
        // if there are no intersections:
        if (l == null) {
            return null;
        }
        // if there is 1 intersection, return it.
        if (l.size() == 1) {
            return l.get(0);

        }
        // if there are 2, return the closest one.
        if (l.get(0).distance(this.start) < l.get(1).distance(this.start)) {
            return l.get(0);
        }
        return l.get(1);
    }
}