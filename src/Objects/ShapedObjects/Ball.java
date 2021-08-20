package Objects.ShapedObjects;

import Objects.CollisionInfo;
import Objects.Sprite;
import biuoop.DrawSurface;
import Shapes.Line;
import Shapes.Point;
import Shapes.Velocity;
import Objects.GameLevel;
import Removers.HitListener;
import Removers.HitNotifier;
import Objects.GameEnvironment;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Ball implements Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private Point point;
    private int radius;
    private Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * This is a function how construct a new ball.
     *
     * @param x     double
     * @param y     double
     * @param r     int
     * @param color Color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {

        this.point = new Point(x, y);
        this.radius = r;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }


    /**
     * This is a function how set the velocity of the ball.
     *
     * @param v shapes.Velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * This is a function how set the gameEnvironment of the ball.
     *
     * @param g Obgects.GameEnvironment.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * This is a function how return the X of the center of the ball.
     *
     * @return int
     */
    public int getX() {
        return (int) this.point.getX();
    }

    /**
     * This is a function how return the Y of the center of the ball..
     *
     * @return int
     */
    public int getY() {
        return (int) this.point.getY();
    }

    /**
     * This is a function how returns the radius of the ball.
     *
     * @return int
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * This is a function how returns the color of the ball.
     *
     * @return java.awt.Color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * This is a function how returns the hit listeners list of the ball.
     *
     * @return List<HitListener>
     */
    public List<HitListener> getHitListeners() {
        return this.hitListeners;
    }

    /**
     * This is a function how draw the ball on the surface.
     *
     * @param surface DrawSurface
     */
    public void drawOn(DrawSurface surface) {
        java.awt.Color c = this.getColor();
        int x = this.getX();
        int y = this.getY();
        int r = this.getSize();
        surface.setColor(Color.getColor(c.toString(), c));
        surface.fillCircle(x, y, r);
    }

    /**
     * This is a function how return the velocity of the ball.
     *
     * @return shapes.Velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }


    /**
     * This is a function how return the Obgects.GameEnvironment of the ball.
     *
     * @return Obgects.GameEnvironment
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }


    /**
     * This is a function how move the ball one step, based on its velocity.
     * it used 3 different lines to check the location of the ball in a case
     * of a collusion.
     */
    public void moveOneStep() {
        int factorX = 1, factorY = 1;
        //factors of the velocity that will used latter.
        if (this.velocity.getDx() < 0) {
            factorX = -1;
        }
        if (this.velocity.getDy() < 0) {
            factorY = -1;
        }
        // new line to find the actual collision.
        Line l = new Line(this.point, this.velocity.applyToPoint(this.point));
        // new lin to find the X collision.
        Line lX = new Line(this.point.getX() + this.radius * factorX, this.point.getY(),
                this.point.getX() + this.radius * factorX + this.velocity.getDx(), this.point.getY());
        // new lin to find the Y collision.
        Line lY = new Line(this.point.getX(), this.point.getY() + this.radius * factorY,
                this.point.getX(), this.point.getY() + this.radius * factorY + this.velocity.getDy());
        // if there is no collision, move one normal step.
        if (this.gameEnvironment.getClosestCollision(lX) == null
                && this.gameEnvironment.getClosestCollision(lY) == null
                && this.gameEnvironment.getClosestCollision(l) == null) {
            this.point = this.velocity.applyToPoint(this.point);
        } else if (this.gameEnvironment.getClosestCollision(lX) != null
                || this.gameEnvironment.getClosestCollision(lY) != null) {
            // if the collision if on the Y.
            if (this.gameEnvironment.getClosestCollision(lY) != null) {
                CollisionInfo c = this.gameEnvironment.getClosestCollision(lY);
                this.point = new Point(this.velocity.applyToPoint(this.point).getX(),
                        c.collisionPoint().getY() - factorY * radius);
                this.setVelocity(c.collisionObject().hit(this, c.collisionPoint(), this.velocity));
            }
            //if the collision is on X.
            if (this.gameEnvironment.getClosestCollision(lX) != null) {
                CollisionInfo c = this.gameEnvironment.getClosestCollision(lX);
                this.point = new Point(c.collisionPoint().getX() - factorX * radius,
                        this.velocity.applyToPoint(this.point).getY());
                this.setVelocity(c.collisionObject().hit(this, c.collisionPoint(), this.velocity));
            }
        } else {
            // if the ball collision is in the corner ot the rectangle.
            CollisionInfo c = this.gameEnvironment.getClosestCollision(l);
            this.setVelocity(c.collisionObject().hit(this, c.collisionPoint(), this.velocity));
        }

    }

    /**
     * This is a function how calls all the functions how need
     * we need to use whet time has passed.
     * implement: Obgects.Sprite.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * This is a function how add the ball to the game.
     *
     * @param g Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * This is a function how remove the ball to the game.
     *
     * @param game Game.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
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