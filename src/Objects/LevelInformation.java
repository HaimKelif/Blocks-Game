package Objects;

import Objects.ShapedObjects.Block;
import Shapes.Velocity;

import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public interface LevelInformation {
    /**
     * @return int
     */
    int numberOfBalls();

    /**
     * @return List<Velocity>
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return int
     */
    int paddleSpeed();

    /**
     * @return int
     */
    int paddleWidth();


    /**
     * @return String level name
     */
    String levelName();

    /**
     * @return SpriteCollection
     */
    SpriteCollection getBackground();

    /**
     * @return List<Block>
     */
    List<Block> blocks();

    /**
     * @return int
     */
    int numberOfBlocksToRemove();
}
