package Objects;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;


    /**
     * Key press stoppable animation.
     *
     * @param sensor    KeyboardSensor
     * @param key       String
     * @param animation Animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.key = key;
        this.keyboardSensor = sensor;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        } else {
            isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}