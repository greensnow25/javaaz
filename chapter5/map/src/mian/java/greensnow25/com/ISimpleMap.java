package greensnow25.com;

/**
 * public class ISimpeMap.
 *
 * @author greensnow25.
 * @version 1.
 * @since 25.05.2017.
 */
public interface ISimpleMap<K, V> extends Iterable<V> {
    /**
     * add object to the map.
     *
     * @param key   key.
     * @param value value.
     * @return if inserted successful return true, else false.
     */
    boolean insert(K key, V value);

    /**
     * get value by key.
     *
     * @param key key of searching element.
     * @return value.
     */
    V get(K key);

    /**
     * delete element from map.
     *
     * @param key key.
     * @return if deleted successful return true, else false.
     */
    boolean delete(K key);
}
