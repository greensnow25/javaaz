package com.greensnow25;

/**
 * public class UserRole.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.05.2017.
 */
public class RoleStore implements Store {
    /**
     * class object.
     */
    private SimpleArray<Base> list;

    /**
     * constructor.
     */
    public RoleStore() {
        this.list = new SimpleArray<>();
    }

    /**
     * add.
     *
     * @param value class extends of Base.
     */
    @Override
    public void add(Base value) {
        if (value instanceof Role) this.list.add(value);
    }

    /**
     * update.
     *
     * @param oldValue old.
     * @param newValue new.
     */
    @Override
    public void update(Base oldValue, Base newValue) {
        this.update(oldValue, newValue);
    }

    /**
     * remove.
     *
     * @param value which need to remove.
     */
    @Override
    public void remove(Base value) {
        this.remove(value);
    }
}
