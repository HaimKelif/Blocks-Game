package Removers;

import Objects.GameLevel;
import Objects.ShapedObjects.Ball;
import Objects.ShapedObjects.Block;
import Score.Counter;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Constructor.
     *
     * @param game          GameLevel.
     * @param removedBlocks Counter.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.game);
        remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
    }

    /**
     * the function returns the remaining blocks.
     *
     * @return Counter.
     */
    public Counter getRemainingBlocks() {
        return this.remainingBlocks;
    }
}