package Removers;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public interface HitNotifier {

    /**
     * the function add hit listeners.
     *
     * @param hl HitListener.
     */
    void addHitListener(HitListener hl);

    /**
     * the function removes hit listeners.
     *
     * @param hl HitListener.
     */
    void removeHitListener(HitListener hl);
}