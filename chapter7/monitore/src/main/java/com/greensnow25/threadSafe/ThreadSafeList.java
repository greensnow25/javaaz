package com.greensnow25.threadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * public class SimpleArray.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class ThreadSafeList<T> implements SimpleContainer<T> {
    /**
     * array of obgects.
     */
    private Object[] array;
    /**
     * position in the array.
     */
    private int index = 0;

    /**
     * constructor.
     */
    public ThreadSafeList() {
        array = new Object[1];
    }

    /**
     * add object to the array.
     *
     * @param t object.
     */
    @Override
    public void add(T t) {
        synchronized (this) {
            if (index == array.length) {
                Object[] tmp = array;
                System.arraycopy(tmp, 0, this.array = new Object[index * 2], 0, tmp.length);
                this.add(t);
            } else {
                array[index++] = t;
            }
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
        synchronized (this) {
            if (index > this.index) {
                throw new ArrayIndexOutOfBoundsException("out");
            }
            return (T) array[index];
        }
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
             * iterator position.
             */
            private volatile int position = 0;

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
                synchronized (this) {
                    return array[position++];
                }
            }
        };
    }

    public int length(){
        synchronized (this){
         //   for(int i = 0;i!)
        }
        return 0;
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

