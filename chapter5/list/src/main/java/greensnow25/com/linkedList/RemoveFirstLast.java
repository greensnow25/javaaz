package greensnow25.com.linkedList;

/**
 * public class RemoveFirstLast.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.05.2017.
 */
public interface RemoveFirstLast<T> {
    /**
     * remove first element.
     *
     * @return removable item.
     */
    T removeFirst();

    /**
     * remove last element.
     *
     * @return removable item.
     */
    T removeLast();
}
