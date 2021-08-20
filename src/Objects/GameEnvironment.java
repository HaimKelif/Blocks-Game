package Objects;

import Shapes.Line;
import Shapes.Point;
import Shapes.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class GameEnvironment {
    private List<Collidable> collidables;

    /**
     * this function construct a new Obgects.GameEnvironment.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }

    /**
     * this function add Collidables to the game environment.
     *
     * @param c Dollidable.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * this function get a line and return the cosest collision
     * from the start of the line.
     *
     * @param trajectory shapes.Line
     * @return Obgects.CollisionInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Rectangle r = null;
        Point returningPoint = null;
        Collidable returningCollidable = null;
        double smallDistance = 1000;
        //for all collidebles in gameEnvironment:
        for (Collidable c : collidables) {
            r = c.getCollisionRectangle();
            Point p = trajectory.closestIntersectionToStartOfLine(r);
            //if the is an intersection ang its closer the the others:
            if (p != null && trajectory.start().distance(p) < smallDistance) {
                smallDistance = trajectory.start().distance(p);
                returningPoint = p;
                returningCollidable = c;
            }
        }
        // if there are no intersections:
        if (returningPoint == null) {
            return null;
        }
        return new CollisionInfo(returningPoint, returningCollidable);
    }

    /**
     * the function returns the collidables list.
     *
     * @return List<Collidable>
     */
    public List<Collidable> getCollidables() {
        return this.collidables;
    }
}