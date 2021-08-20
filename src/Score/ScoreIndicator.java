package Score;

import Objects.Sprite;
import Objects.GameLevel;
import biuoop.DrawSurface;


import java.awt.Color;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private String name;

    /**
     * @param c    Counter
     * @param name String
     */
    public ScoreIndicator(Counter c, String name) {
        this.score = c;
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(350, 15, "Score " + this.score.getValue(), 14);
        d.drawText(550, 15, "Level Name: " + name, 14);
    }

    @Override
    public void timePassed() {
    }

    /**
     * the function add the score indicator to the game.
     *
     * @param g Game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}