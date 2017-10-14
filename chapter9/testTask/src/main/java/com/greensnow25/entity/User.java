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
    private Address address;
    private MusicType type;
    private Role role;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public User(String name, Address address, MusicType type, Role role, int id) {
        this.name = name;
        this.address = address;
        this.type = type;
        this.role = role;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
