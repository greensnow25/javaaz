package com.greensnow25;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 06.04.2017.
 */
public class User {
    /**
     * user name.
     */
    private String name;
    /**
     * user pasport.
     */
    private String pasport;

    /**
     * class constructor.
     *
     * @param name    user.
     * @param pasport user.
     */
    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return pasport != null ? pasport.equals(user.pasport) : user.pasport == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pasport != null ? pasport.hashCode() : 0);
        return result;
    }
}
