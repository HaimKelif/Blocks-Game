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
public class FinalFour implements LevelInformation {
    private int paddelSpeed = 12;
    private int paddelWidth = 100;

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            l.add(Velocity.fromAngleAndSpeed(150 + i * 30, 9));
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
        return "Final Four";
    }

    @Override
    public SpriteCollection getBackground() {
        SpriteCollection s = new SpriteCollection();
        Block b = new Block(new Rectangle(new Point(10, 30), 780, 580), Color.blue);
        s.addSprite(b);
        return s;
    }

    @Override
    public List<Block> blocks() {
        List<Block> l = new LinkedList<>();
        Random rand = new Random();
        for (int j = 7; j > 0; j--) {
            Color color = new Color(rand.nextInt(0xFFFFFF));
            //for number of blocks in a column.
            for (int i = 0; i < 15; i++) {
                Point p = new Point(10 + (i * 52), 300 - j * 20);
                Rectangle r = new Rectangle(p, 52, 20);
                Block b = new Block(r, color);
                l.add(b);
            }
        }
        return l;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}