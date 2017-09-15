package com.greensnow25.model;

/**
 * Public class Role.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.09.2017.
 */
public class Role {
    /**
     * user role.
     */
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
