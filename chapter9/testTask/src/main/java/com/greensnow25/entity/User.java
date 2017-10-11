package com.greensnow25.entity;

/**
 * Public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.10.2017.
 */
public class User {
    /**
     * name.
     */
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
