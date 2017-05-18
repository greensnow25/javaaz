package greensnow25.com.cyclicity;

/**
 * public class Cycle.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.05.2017.
 */
public interface Cycle<T> {
    /**
     * Checks the list for cyclicity.
     *
     * @param first first Node.
     * @return true, if list has a cycle;
     */
    boolean hasCycle(Node<T> first);
}
