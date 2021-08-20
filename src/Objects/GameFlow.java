package Objects;

import Score.Counter;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    private Counter counter;

    /**
     * This function runs the flow of the game.
     *
     * @param ar  AnimationRunner
     * @param ks  KeyboardSensor
     * @param gui GUI
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.keyboardSensor = ks;
        this.gui = gui;
        this.animationRunner = ar;
        this.counter = new Counter(0);

    }

    /**
     * This function runs the flow of the game.
     *
     * @param levels List<LevelInformation>
     */
    public void runLevels(List<LevelInformation> levels) {
        int counter2 = 0;
        for (LevelInformation levelInfo : levels) {
            counter2 = counter.getValue();
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.gui, counter);
            level.initialize();
            level.run();
            counter2 = counter.getValue() - counter2;
            if (levelInfo.numberOfBlocksToRemove() > counter2 / 5) {
                Animation gameOver = new GameOver(counter);
                Animation key1 = new KeyPressStoppableAnimation(this.keyboardSensor, "c", gameOver);
                animationRunner.run(key1, gui, 60);
                break;
            } else {
                Animation youWin = new YouWin(counter);
                Animation key2 = new KeyPressStoppableAnimation(this.keyboardSensor, "c", youWin);
                animationRunner.run(key2, gui, 60);
            }
        }
        gui.close();
    }
}