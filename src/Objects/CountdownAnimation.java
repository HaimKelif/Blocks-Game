package Objects;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconde;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;

    /**
     * constructor of count down animation function.
     *
     * @param numOfSeconds double
     * @param countFrom    int
     * @param gameScreen   SpriteCollection
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconde = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.white);
        if (countFrom == 0) {
            d.drawText(300, d.getHeight() / 2 + 50, "go!!!", 100);
            this.stop = true;
        } else {
            d.drawText(370, d.getHeight() / 2 + 50, String.valueOf(countFrom), 100);
            countFrom = countFrom - 1;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}