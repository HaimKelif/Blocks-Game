package Objects.ShapedObjects;

import Objects.Collidable;
import Objects.Sprite;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;
import Removers.HitListener;
import Removers.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class DeathRegion extends Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Rectangle rectangle;
    private Color color;

    /**
     * This is a function how construct a new Obgects.ShapedObjects.Block
     * with a rectangle and color.
     *
     * @param rect  shapes.Rectangle
     * @param color Color
     */
    public DeathRegion(Rectangle rect, Color color) {
        super(rect, color);
    }

    /**
     * This is a function how construct a new Obgects.ShapedObjects.Block
     * with a rectangle and color.
     *
     * @param rect  shapes.Rectangle
     * @param color Color
     */
    public void deathRegion(Shapes.Rectangle rect, Color color) {
        this.rectangle = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        return currentVelocity;
    }

    /**
     * This is a function how notify the block hit.
     *
     * @param hitter Ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(hitter.getHitListeners());
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}