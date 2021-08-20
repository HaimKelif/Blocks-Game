package Removers;

import Objects.ShapedObjects.Ball;
import Objects.ShapedObjects.Block;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public interface HitListener {

    /**
     * when the is a hit.
     *
     * @param beingHit Block
     * @param hitter   Ball
     */
    void hitEvent(Block beingHit, Ball hitter);
}