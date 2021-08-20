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
public class WideEasy implements LevelInformation {
    private int paddelSpeed = 10;
    private int paddelWidth = 600;

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            l.add(Velocity.fromAngleAndSpeed(130 + i * 10, 9));
        }
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
        return "Wide Easy";
    }

    @Override
    public SpriteCollection getBackground() {
        SpriteCollection s = new SpriteCollection();
        Block b = new Block(new Rectangle(new Point(10, 30), 780, 580), Color.orange);
        s.addSprite(b);
        return s;
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            l.add(new Block(new Rectangle(new Point(10 + 52 * i, 150), 52, 20), Color.red));
        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}