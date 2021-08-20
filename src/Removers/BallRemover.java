package Removers;

import Objects.GameLevel;
import Objects.ShapedObjects.Ball;
import Objects.ShapedObjects.Block;
import Score.Counter;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor.
     *
     * @param game          GameLevel.
     * @param removedBlocks Counter.
     */
    public BallRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBalls = removedBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        game.getCountBalls().decrease(1);
        hitter.removeHitListener(this);
    }

    /**
     * the function returns the remaining balls.
     *
     * @return Counter.
     */
    public Counter getRemainingBalls() {
        return this.remainingBalls;
    }
}