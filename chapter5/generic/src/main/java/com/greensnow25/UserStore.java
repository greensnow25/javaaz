package com.greensnow25;

/**
 * public class UserStore.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.05.2017.
 */
public class UserStore implements Store {
    /**
     * class object.
     */
    private SimpleArray<Base> list;

    /**
     * constructor.
     */
    public UserStore() {
        this.list = new SimpleArray<>();
    }

    /**
     * add.
     *
     * @param value class extends of Base.
     */
    @Override
    public void add(Base value) {
        if (value instanceof User) this.list.add(value);
    }

    /**
     * update.
     *
     * @param oldValue old.
     * @param newValue new.
     */
    @Override
    public void update(Base oldValue, Base newValue) {
        this.list.update(oldValue, newValue);
    }

    /**
     * remove.
     *
     * @param value which need to remove.
     */
    @Override
    public void remove(Base value) {
        this.list.delete(value);
    }

    /**
     * get list.
     *
     * @return list.
     */
    public SimpleArray<Base> getList() {
        return list;
    }
}
