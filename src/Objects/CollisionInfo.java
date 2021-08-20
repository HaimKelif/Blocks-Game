package Objects;

import Shapes.Point;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class CollisionInfo {

    private Point point;
    private Collidable object;

    /**
     * this is the function how construct the Obgects.CollisionInfo.
     *
     * @param p shapes.Point.
     * @param c Obgects.Collidable.
     */
    public CollisionInfo(Point p, Collidable c) {
        this.point = p;
        this.object = c;
    }

    /**
     * this function returns the collision point.
     *
     * @return shapes.Point of collision.
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     * this function returns the object of the collision.
     *
     * @return Obgects.Collidable.
     */
    public Collidable collisionObject() {
        return this.object;
    }
}