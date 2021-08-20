package Objects;

import Objects.ShapedObjects.Ball;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public interface Collidable {
    /**
     * function return the rectangle.
     *
     * @return shapes.Rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * function returns the new velocity after the hit.
     *
     * @param collisionPoint  shapes.Point.
     * @param currentVelocity shapes.Velocity.
     * @param hitter Ball.
     * @return velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}