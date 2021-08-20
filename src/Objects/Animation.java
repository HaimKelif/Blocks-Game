package Objects;

import biuoop.DrawSurface;


/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public interface Animation {

    /**
     * function how do one frame in the game.
     *
     * @param d DrawSurface.
     */
    void doOneFrame(DrawSurface d);


    /**
     * check if the function should stop.
     *
     * @return boolean.
     */
    boolean shouldStop();
}