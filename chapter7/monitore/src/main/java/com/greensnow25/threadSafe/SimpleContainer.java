package com.greensnow25.threadSafe;

/**
 * public class ArrayListContainer.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * add item.
     *
     * @param e item.
     */
    void add(E e);

    /**
     * get item.
     *
     * @param index in the container.
     * @return item.
     */
    E get(int index);
}
