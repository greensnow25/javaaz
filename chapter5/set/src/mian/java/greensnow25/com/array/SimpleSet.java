package greensnow25.com.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * public class SimleSet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.05.2017.
 */
public class SimpleSet<T> implements Iterable<T> {
    /**
     * objects array.
     */
    private Object[] objects;
    /**
     * position in the array.
     */
    private int position = 0;

    /**
     * constructor.
     *
     * @param size array.
     */
    public SimpleSet(int size) {
        this.objects = new Object[size];
    }

    /**
     * add object to array, if such an object does not exist, then an addition occurs.
     *
     * @param object object to add.
     */
    public void add(T object) {
        boolean canAdd = true;
        for (Object o : this.objects) {
            if (object.equals((T) o)) {
                canAdd = false;
                break;
            }
        }
        if (canAdd) {
            this.objects[position++] = object;
        }
    }

    /**
     * method moves by array.
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return position > this.pos;
            }

            @Override
            public T next() {
                for (int i = this.pos; ; i++) {
                    if (objects[pos] == null) {
                        throw new NoSuchElementException("no elements");
                    }
                    return (T) objects[this.pos++];
                }
            }
        };
    }

    /**
     * get position.
     * @return position.
     */
    public int getPosition() {
        return position;
    }
}
