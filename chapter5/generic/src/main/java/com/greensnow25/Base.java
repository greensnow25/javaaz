package com.greensnow25;

/**
 * public class Base.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.05.2017.
 */
public abstract class Base {
    /**
     * id.
     */
    private int id;

    /**
     * constructor.
     *
     * @param id id.
     */
    public Base(int id) {
        this.id = id;
    }

    /**
     * get.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }

    /**
     * set.
     *
     * @param id id.
     */
    public void setId(int id) {
        this.id = id;
    }
}

