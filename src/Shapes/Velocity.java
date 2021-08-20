package Shapes;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Velocity {
    // constructor
    private double dx;
    private double dy;

    /**
     * This is a function how construct the velocity.
     *
     * @param dx double
     * @param dy double
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This is a function how construct the velocity.
     *
     * @param angle double
     * @param speed double
     * @return shapes.Velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dy = speed * Math.cos(Math.toRadians(angle));
        double dx = speed * Math.sin(Math.toRadians(angle));
        return new Velocity(-dx, -dy);
    }


    /**
     * This is a function how return the DX of velocity.
     *
     * @return double
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * This is a function how returns the DY of velocity.
     *
     * @return double
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * the functionreturn the angle of the velocity.
     *
     * @return double.
     */
    public double getAngle() {
        if (this.getDy() < 0 && this.getDx() < 0) {
            return Math.toDegrees(Math.tanh(dy / dx)) + 180;
        }
        if (this.dx < 0) {
            return Math.toDegrees(Math.tanh(dy / dx)) + 180;
        }
        return Math.toDegrees(Math.tanh(dy / dx));
    }

    /**
     * the function returns the speed of the velocity.
     *
     * @return double.
     */
    public double getSpeed() {
        return Math.sqrt(this.getDx() * this.getDx() + this.getDy() * this.getDy());
    }


    /**
     * This is a function how get a point and returns a new point with the velocity.
     *
     * @param p shapes.Point
     * @return shapes.Point
     */
    public Point applyToPoint(Point p) {
        Point point = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return point;
    }
}