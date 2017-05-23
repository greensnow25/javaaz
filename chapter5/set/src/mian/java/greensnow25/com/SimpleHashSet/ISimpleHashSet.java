package greensnow25.com.SimpleHashSet;

/**
 * public class ISimpleHashSet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.05.2017.
 */
public interface ISimpleHashSet<E> extends Iterable<E> {
    /**
     * add e to the set.
     * @param e value.
     * @return is operation is successful return true.
     */
    boolean add(E e);
}
