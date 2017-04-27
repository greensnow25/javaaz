package com.greensnow25;

/**
 * public class Bag.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class Bag extends Exception {
    /**
     * name.
     */
    private String name;

    /**
     * class constructor.
     *
     * @param name name.
     */
    public Bag(String name) {
        this.name = name;
        System.out.println(name);
    }
}
