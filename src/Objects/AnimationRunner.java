package Objects;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;


    /**
     * the function run the animation.
     *
     * @param animation       Animation
     * @param gui             GUI
     * @param framesPerSecond int
     */
    public void run(Animation animation, GUI gui, int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        this.sleeper = new biuoop.Sleeper();
        this.gui = gui;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}