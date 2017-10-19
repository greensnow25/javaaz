package com.greensnow25.repository;

/**
 * Public class UserByNAmeSQLSpecification.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.10.2017.
 */
public class UserLoginSQLSpecification implements SqlSpecification {
    /**
     * user name.
     */
    private final String name;
    /**
     * password.
     */
    private final String pwd;

    public UserLoginSQLSpecification(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public String toSQLQuery() {
        return String.format("WHERE U.name = \'%s\' AND U.password = \'%s\'", this.name, this.pwd);
    }
}
