package com.greensnow25.model;

import java.sql.Timestamp;

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
    private final String eMail;
    /**
     * create date.
     */
    private final Timestamp createDate;

    /**
     * @param login      q.
     * @param eMail      q.
     * @param createDate q.
     */
    public User(String login, String eMail, Timestamp createDate) {
        this.login = login;
        this.eMail = eMail;
        this.createDate = createDate;
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
    public String geteMail() {
        return eMail;
    }

    /**
     * create date.
     *
     * @return create date.
     */
    public Timestamp getCreateDate() {
        return createDate;
    }
}
