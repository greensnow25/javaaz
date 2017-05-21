package com.greensnow25;

/**
 * public class Store.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.05.2017.
 */
public interface Store<T extends Base> {
    /**
     * add value to the storage.
     *
     * @param value class extends of Base.
     */
    public void add(T value);

    /**
     * update value in the storage.
     *
     * @param oldValue old.
     * @param newValue new.
     */
    public void update(T oldValue, T newValue);

    /**
     * remove value from predetermined sequence.
     *
     * @param value which need to remove.
     */
    public void remove(T value);

}
