package greensnow25.com.arrayList;

import java.util.Iterator;

/**
 * public class SimpleArray.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class SimpleArray<T> implements ArrayListContainer<T> {
    /**
     * array of obgects.
     */
    private Object[] array;
    /**
     * position in the array.
     */
    private int index = 0;
    /**
     * iterator position.
     */
    private int position = 0;

    /**
     * constructor.
     */
    public SimpleArray() {
        array = new Object[1];
    }

    /**
     * add object to the array.
     *
     * @param t object.
     */
    @Override
    public void add(T t) {
        if (index == array.length) {
            Object[] tmp = array;
            System.arraycopy(tmp, 0, this.array = new Object[index * 2], 0, tmp.length);
            this.add(t);
        } else {
            array[index++] = t;
        }
    }

    /**
     * get object from array with specified position.
     *
     * @param index in the container.
     * @return object.
     */
    @Override
    public T get(int index) {
        if (index > this.index) {
            throw new ArrayIndexOutOfBoundsException("out");
        }
        return (T) array[index];
    }

    /**
     * override iterator.
     *
     * @return object.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            /**
             * method checks availability next element in the array.
             * @return true if current position less of array length.
             */
            @Override
            public boolean hasNext() {

                return position <= array.length - 1;
            }

            /**
             * method return object and move pointer wright.
             * if pointer in the end of the array, then generate  ArrayIndexOutOfBoundsException.
             * @return
             */
            @Override
            public Object next() {
                return array[position++];
            }
        };
    }

    /**
     * get array.
     *
     * @return array.
     */
    public Object[] getArray() {
        return array;
    }
}

