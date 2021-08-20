package Objects;

import biuoop.DrawSurface;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d DrawSurface.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}