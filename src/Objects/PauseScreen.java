package Objects;

import biuoop.DrawSurface;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * Constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(150, d.getHeight() / 2, "paused -- press 'c' to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
