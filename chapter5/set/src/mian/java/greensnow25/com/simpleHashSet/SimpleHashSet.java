package greensnow25.com.simpleHashSet;

import java.util.*;

/**
 * public class simpleHashSet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.05.2017.
 */
public class SimpleHashSet<E> implements ISimpleHashSet<E> {
    /**
     * array of objects.
     */
    private Object[][] set;
    /**
     * size array.
     */
    private final int size;

    /**
     * constructor.
     *
     * @param size size array.
     */
    public SimpleHashSet(int size) {
        this.size = size;
        this.set = new Object[this.size][this.size];
    }

    /**
     * add value to the set.
     *
     * @param e value.
     * @return if ad original value successful return true, if add duplicate return false and.
     * no addition to the array occurs.
     */
    @Override
    public boolean add(E e) {
        int position = 0;
        boolean canAdd = true;
        int group = e.hashCode() % this.size;
        for (int i = 0; i != set[group].length; i++) {
            if (set[group][position] == null) break;
            if (set[group][position].equals(e)) {
                canAdd = false;
                break;
            }
            position++;
        }
        if (canAdd) {
            set[group][position] = e;
            return true;
        }
        return false;
    }

    /**
     * create Iterator object.
     *
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            /**
             * group is column of the array.
             */
            private int group = 0;
            /**
             * pointer is row of the array.
             */
            private int pointer = 0;

            /**
             * The method checks the presence of an element after the pointer.
             * @return If after the pointer there are elements, return true, else false.
             */
            @Override
            public boolean hasNext() {
                for (; group != set.length; this.group++) {
                    for (; pointer != set[group].length; this.pointer++) {
                        if (set[group][pointer] != null) return true;
                    }
                    pointer = 0;
                }
                return false;
            }

            /**
             * The method returns the next element after the pointer.
             * @return element.
             * @throws ArrayIndexOutOfBoundsException If a method is called .
             * when there are no items after the pointer.

             */
            @Override
            public E next() {
                for (; ; this.group++) {
                    for (; pointer != set[group].length - 1; this.pointer++) {
                        if (set[group][pointer] != null) return (E) set[group][pointer++];
                    }
                    pointer = 0;
                }
            }
        };
    }
}
