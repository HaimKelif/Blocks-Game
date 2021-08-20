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
import java.util.Random;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Green3 implements LevelInformation {
    private int paddelSpeed = 12;
    private int paddelWidth = 100;

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new LinkedList<>();
        for (int i = 0; i < 2; i++) {
            l.add(Velocity.fromAngleAndSpeed(170 + i * 20, 9));
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
        return "Green 3";
    }

    @Override
    public SpriteCollection getBackground() {
        SpriteCollection s = new SpriteCollection();
        Block b = new Block(new Rectangle(new Point(10, 30), 780, 580), Color.green);
        s.addSprite(b);
        return s;
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new LinkedList<>();
        Random rand = new Random();
        for (int j = 10; j > 5; j--) {
            Color color = new Color(rand.nextInt(0xFFFFFF));
            //for number of blocks in a column.
            for (int i = 0; i < j; i++) {
                Point p = new Point(290 + (i + 10 - j) * 50, 400 - j * 20);
                Rectangle r = new Rectangle(p, 50, 20);
                Block b = new Block(r, color);
                l.add(b);
            }
        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}