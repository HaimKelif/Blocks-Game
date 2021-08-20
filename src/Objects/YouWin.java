package Objects;

import Score.Counter;
import biuoop.DrawSurface;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class YouWin implements Animation {
    private Counter counter;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param counter Counter
     */
    public YouWin(Counter counter) {
        this.counter = counter;
        this.stop = false;

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(150, d.getHeight() / 2, "You Win!!! Your score is: " + counter.getValue(), 32);
        d.drawText(300, d.getHeight() / 2 + 40, "press 'c' to continue", 15);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}