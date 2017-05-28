package greensnow25.com;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * public class SimpleMap.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.05.2017.
 */
public class SimpleMap<K extends User, V> implements ISimpleMap<K, V> {

    /**
     * handbook.
     */
    private Object[] map;
    /**
     * size of handbook.
     */
    private int size;

    /**
     * constructor.
     *
     * @param size size of array.
     */
    public SimpleMap(int size) {
        this.size = size;
        this.map = new Object[this.size];
    }

    /**
     * inserted element to the handbook.
     *
     * @param key   key.
     * @param value value.
     * @return if inserted successful return true, else false.
     */
    @Override
    public boolean insert(K key, V value) {
        int bucket = this.giveMeBucket(key);
        if (this.map[bucket] == null) {
            this.map[bucket] = value;
            return true;
        }
        return false;
    }

    /**
     * method return value at the specified key.
     *
     * @param key key of searching element.
     * @return value.
     */
    @Override
    public V get(K key) {
        int bucket = this.giveMeBucket(key);

        return (V) map[bucket];
    }

    /**
     * delete element by key.
     *
     * @param key key.
     * @return true if successful, else false.
     */
    @Override
    public boolean delete(K key) {
        int bucket = this.giveMeBucket(key);
        if (this.map[bucket] == null) return false;
        this.map[bucket] = null;
        return true;
    }

    /**
     * method return object iterator.
     *
     * @return new Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int position = 0;

            /**
             * check
             * @return
             */
            @Override
            public boolean hasNext() {
                for (int i = position ; i != map.length; i++) {
                    if (map[i] != null) {
                        return true;
                    }
                }
                return false;
            }

            /**
             * return next element.
             * @return next element.
             * @throws ArrayIndexOutOfBoundsException if out of range.
             */
            @Override
            public V next() {
                while (true) {
                    if (map[position++] != null) {
                        return (V) map[position - 1];
                    } else if (this.position > size) {
                        throw new ArrayIndexOutOfBoundsException("out of range");
                    }
                }
            }
        };
    }

    /**
     * Method generates a basket for an element with a given key.
     *
     * @param key key.
     * @return number of bucket.
     */
    private int giveMeBucket(K key) {
        return Math.abs(key.hashCode() % this.size);
    }

    public Object[] getMap() {
        return map;
    }

    public int getSize() {
        return size;
    }
}
