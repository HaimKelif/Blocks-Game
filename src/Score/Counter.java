package Score;

/**
 * @author [Haim Kelif] [hainklif77@gmail.com]
 * ID 313377103
 */
public class Counter {
    private int count;

    /**
     * Constructor.
     *
     * @param count int.
     */
    public Counter(int count) {
        this.count = count;
    }

    /**
     * Increase the count.
     *
     * @param number int.
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * Decrease the count.
     *
     * @param number int.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * return the valuo.
     *
     * @return int.
     */
    public int getValue() {
        return this.count;
    }

}
