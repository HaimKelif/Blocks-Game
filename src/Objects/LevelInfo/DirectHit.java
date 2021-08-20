package Objects.LevelInfo;

import Objects.LevelInformation;
import Objects.ShapedObjects.Block;
import Objects.SpriteCollection;
import Shapes.Point;
import Shapes.Rectangle;
import Shapes.Velocity;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class DirectHit implements LevelInformation {
    private int paddelSpeed = 12;
    private int paddelWidth = 100;

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new LinkedList<>();
        l.add(Velocity.fromAngleAndSpeed(0, 9));
        return l;
    }

    @Override
    public int paddleSpeed() {
        return paddelSpeed;
    }

    @Override
    public int paddleWidth() {
        return paddelWidth;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public SpriteCollection getBackground() {
        SpriteCollection s = new SpriteCollection();
        Block b = new Block(new Rectangle(new Point(10, 30), 780, 580), Color.BLACK);
        s.addSprite(b);
        return s;
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new LinkedList<>();
        l.add(new Block(new Rectangle(new Point(375, 150), 30, 30), Color.red));
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
