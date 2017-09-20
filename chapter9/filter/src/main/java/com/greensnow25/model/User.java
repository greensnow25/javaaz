package com.greensnow25.model;


/**
 * Public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 08.09.2017.
 */
public class User {
    /**
     * login.
     */
    private final String login;
    /**
     * email.
     */
    private final String password;
    /**
     * create date.
     */
    private final String role;

    /**
     * @param login      q.
     * @param password   p.
     * @param role
     */
    public User(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /**
     * login.
     *
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * eMail.
     *
     * @return eMail.
     */
    public String getPassword() {
        return password;
    }

    /**
     * create date.
     *
     * @return create date.
     */
    public String getRole() {
        return role;
    }
}
