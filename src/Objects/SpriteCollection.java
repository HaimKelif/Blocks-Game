package Objects;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * the function construct a new Obgects.SpriteCollection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * the function add the gives Obgects.Sprite to the Obgects.SpriteCollection.
     *
     * @param s Obgects.Sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * the function notify all sprites in this that
     * time has passed.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).timePassed();
        }
    }

    /**
     * the function draw all sprites in Obgects.SpriteCollection.
     *
     * @param d DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).drawOn(d);
        }
    }

    /**
     * the function returns the Srites list.
     *
     * @return List<Sprites>
     */
    public List<Sprite> getSprites() {
        return this.sprites;
    }
}