package Objects;

import Objects.ShapedObjects.Ball;
import Objects.ShapedObjects.Block;
import Objects.ShapedObjects.DeathRegion;
import Objects.ShapedObjects.Paddle;

import Score.Counter;
import Score.ScoreIndicator;
import Score.ScoreTrackingListener;
import biuoop.DrawSurface;
import Shapes.Point;
import Shapes.Rectangle;
import Removers.BlockRemover;
import Removers.BallRemover;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
import java.util.Random;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter countBalls;
    private Counter score;
    private GUI gui;
    private boolean running;
    private AnimationRunner runner;
    private KeyboardSensor keyboard;
    private LevelInformation level;

    /**
     * the function Objects.Game construct the game class.
     *
     * @param level          LevelInformation
     * @param keyboardSensor KeyboardSensor
     * @param runner         AnimationRunner
     * @param score          Counter
     * @param gui            GUI
     */
    public GameLevel(LevelInformation level, KeyboardSensor keyboardSensor,
                     AnimationRunner runner, GUI gui, Counter score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.countBalls = new Counter(0);
        this.score = score;
        this.runner = new AnimationRunner();
        this.level = level;
        this.keyboard = keyboardSensor;
        this.runner = runner;
        this.gui = gui;
    }

    /**
     * Get count balls.
     *
     * @return Counter
     */
    public Counter getCountBalls() {
        return this.countBalls;
    }

    /**
     * the function "addCollidable" add collidables to the game.
     *
     * @param c Collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * this function add Sprites to the game.
     *
     * @param s Obgects.Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * this function remove collidables from the game.
     *
     * @param c Collidable.
     */
    public void removeCollidable(Collidable c) {
        this.environment.getCollidables().remove(c);
    }

    /**
     * this function remove sprites from the game.
     *
     * @param s Sprite.
     */
    public void removeSprite(Sprite s) {
        this.sprites.getSprites().remove(s);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.blue);
        d.fillRectangle(0, 0, 800, 600);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.environment.getCollidables().size() == 6) {
            this.score.increase(100);
            this.running = false;
        }
        if (countBalls.getValue() == 0) {
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            Animation key = new KeyPressStoppableAnimation(this.keyboard, "c", new PauseScreen());
            this.runner.run(key, this.gui, 60);
        }
    }


    /**
     * this function initialize the game, make the balls, the blocks
     * and the paddle, make the gui.
     */
    public void initialize() {
        //rand for color.
        Random rand = new Random();
        BlockRemover blockRemover = new BlockRemover(this, new Counter(0));
        ScoreTrackingListener scoreTracker = new ScoreTrackingListener(this.score);
        //for number of columns.
        for (int i = 0; i < level.getBackground().getSprites().size(); i++) {
            Sprite s = level.getBackground().getSprites().get(i);
            this.addSprite(s);
        }
        for (int i = 0; i < level.blocks().size(); i++) {
            Block b = level.blocks().get(i);
            blockRemover.getRemainingBlocks().increase(1);
            b.addHitListener(blockRemover);
            b.addHitListener(scoreTracker);
            b.addToGame(this);
        }
        // 5 rectangles for the edges.
        Rectangle[] rectangles = new Rectangle[4];
        Block whiteBlock = new Block(new Rectangle(new Point(0, 0), 800, 20), Color.white);
        whiteBlock.addToGame(this);
        rectangles[0] = new Rectangle(new Point(0, 20), 10, 600);
        rectangles[1] = new Rectangle(new Point(790, 20), 10, 600);
        rectangles[2] = new Rectangle(new Point(10, 20), 780, 10);
        rectangles[3] = new Rectangle(new Point(10, 600), 780, 10);
        for (int i = 0; i < 3; i++) {
            Block block = new Block(rectangles[i], Color.gray);
            block.addToGame(this);
        }
        DeathRegion block = new DeathRegion(rectangles[3], Color.gray);
        block.addToGame(this);
        BallRemover ballRemover = new BallRemover(this, new Counter(0));
        for (int i = 0; i < level.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 450, 4, Color.white);
            ball.setVelocity(level.initialBallVelocities().get(i));
            ball.addToGame(this);
            ball.setGameEnvironment(environment);
            countBalls.increase(1);
            ballRemover.getRemainingBalls().increase(1);
            ball.addHitListener(ballRemover);
        }
        // 1 paddle.
        Rectangle rectPaddle = new Rectangle(new Point(400 - level.paddleWidth() / 2, 570), level.paddleWidth(), 20);
        Paddle p = new Paddle(rectPaddle, Color.YELLOW, keyboard, level.paddleSpeed());
        p.addToGame(this);

        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score, level.levelName());
        scoreIndicator.addToGame(this);
    }

    /**
     * the function "run" runs the game with a loop.
     */
    public void run() {
        this.running = true;
        this.runner.run(new CountdownAnimation(3, 3, sprites), this.gui, 1);
        this.runner.run(this, this.gui, 60);
    }
}