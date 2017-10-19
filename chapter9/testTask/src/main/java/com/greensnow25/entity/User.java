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
    private String password;

    public User(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public User(String name, String password, Address address, MusicType type, Role role, int id) {
        this.name = name;
        this.password = password;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MusicType getType() {
        return type;
    }

    public void setType(MusicType type) {
        this.type = type;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
