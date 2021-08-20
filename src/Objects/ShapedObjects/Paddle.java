package Objects.ShapedObjects;

import Objects.Collidable;
import Objects.GameLevel;
import Objects.Sprite;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int speed;

    /**
     * constructor for a new paddle.
     *
     * @param rectangle shapes.Rectangle.
     * @param color     Color.
     * @param keyboard  keyboardSensor.
     * @param speed     int
     */
    public Paddle(Rectangle rectangle, Color color, KeyboardSensor keyboard, int speed) {
        this.rectangle = rectangle;
        this.color = color;
        this.keyboard = keyboard;
        this.speed = speed;
    }

    /**
     * this function moves the paddle one step to the left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() > 10) {
            Point p = new Point(this.rectangle.getUpperLeft().getX() - this.speed,
                    this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    /**
     * this function muves the paddle one step to the right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() < 690) {
            Point p = new Point(this.rectangle.getUpperLeft().getX() + this.speed,
                    this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(p, this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    /**
     * this function notify the moving functions if time passed.
     */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * the function draw the paddle on the given surface.
     *
     * @param d DrawSurface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.YELLOW);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
    }

    /**
     * the function returns the rectangle of this paddle.
     *
     * @return shapes.Rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        int size = (int) this.rectangle.getWidth();
        if (collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + size / 5) {
            Velocity v = Velocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
            return v;
        }
        if (collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + 2 * size / 5) {
            Velocity v = Velocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
            return v;
        }
        if (collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + 3 * size / 5) {
            Point upperLeft = this.rectangle.getUpperLeft();
            double width = this.rectangle.getWidth();
            double height = this.rectangle.getHeight();
            if ((collisionPoint.getX() > upperLeft.getX())
                    && collisionPoint.getX() < upperLeft.getX() + width) {
                currentVelocity = new Velocity(currentVelocity.getDx(), -(currentVelocity.getDy()));
                return currentVelocity;
            }
            if ((collisionPoint.getY() > upperLeft.getY())
                    && collisionPoint.getY() < upperLeft.getY() + height) {
                currentVelocity = new Velocity(-(currentVelocity.getDx()), currentVelocity.getDy());
                return currentVelocity;
            }
            return null;
        }
        if (collisionPoint.getX() < this.rectangle.getUpperLeft().getX() + 4 * size / 5) {
            Velocity v = Velocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
            return v;
        }
        Velocity v = Velocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
        return v;
    }

    /**
     * the function add the paddle to the given game.
     *
     * @param g Obgects.Game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}