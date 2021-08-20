package Objects.ShapedObjects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Objects.Collidable;
import Objects.Sprite;
import biuoop.DrawSurface;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;
import Objects.GameLevel;
import Removers.HitListener;
import Removers.HitNotifier;


/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Block implements Collidable, Sprite, HitNotifier {
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
    public Block(Rectangle rect, Color color) {
        this.rectangle = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Point upperLeft = this.rectangle.getUpperLeft();
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();
        //if the collision is on the width:
        if ((collisionPoint.getX() > upperLeft.getX())
                && collisionPoint.getX() < upperLeft.getX() + width) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
            this.notifyHit(hitter);
        }
        if (collisionPoint.getY() > upperLeft.getY()
                && collisionPoint.getY() < upperLeft.getY() + height) {
            //if the collision is on the height:
            currentVelocity = new Velocity(-(currentVelocity.getDx()), currentVelocity.getDy());
            this.notifyHit(hitter);
        }
        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY()
                , (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY()
                , (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    @Override
    public void timePassed() {
    }

    /**
     * This is a function how add the block to the given game.
     *
     * @param g Game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * This is a function how remove the block to the given game.
     *
     * @param game Game
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite((Sprite) this);
    }

    /**
     * This is a function how notify the block hit.
     *
     * @param hitter Ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}