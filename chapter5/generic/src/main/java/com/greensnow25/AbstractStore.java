package com.greensnow25;

/**
 * public class AbstractStore.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.05.2017.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    /**
     * class object.
     */
    private SimpleArray<T> list =this.list = new SimpleArray<T>();

    public AbstractStore() {

    }

    /**
     * add.
     *
     * @param value class extends of Base.
     */
    @Override
    public void add(T value) {
        this.list.add((T) value);
    }

    /**
     * update.
     *
     * @param oldValue old.
     * @param newValue new.
     */
    @Override
    public void update(T oldValue, T newValue) {
        this.update(oldValue, newValue);
    }

    /**
     * remove.
     *
     * @param value which need to remove.
     */
    @Override
    public void remove(T value) {
        this.list.delete(value);
    }

    /**
     * get.
     *
     * @return object.
     */
    public SimpleArray getList() {
        return list;
    }
}

