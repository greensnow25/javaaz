package greensnow25.com;

/**
 * public class ISimpleTree.
 *
 * @author greensnow25.
 * @version 1.
 * @since 29.05.2017.
 */
public interface ISimpleTree<E extends Comparable> extends Iterable<E>  {
    /**
     * add element child to parent.
     * Parent can have a child list.
     *
     * @param parent parent.
     * @param child  child.
     * @return added result.
     */
    boolean add(E parent, E child);
}
