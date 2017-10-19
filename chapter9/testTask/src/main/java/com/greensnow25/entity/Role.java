package com.greensnow25.entity;

/**
 * Public class Role.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.10.2017.
 */
public class Role {
    /**
     * role.
     */
    private String role;
    /**
     * primari key , id.
     */
    private int id;

    public Role(String role, int id) {
        this.role = role;
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
