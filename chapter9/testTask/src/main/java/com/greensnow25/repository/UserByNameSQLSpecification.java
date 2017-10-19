package com.greensnow25.repository;

/**
 * Public class UserByNameSQLSpecification.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class UserByNameSQLSpecification implements SqlSpecification {
    private final String name;

    public UserByNameSQLSpecification(String name) {
        this.name = name;
    }

    @Override
    public String toSQLQuery() {
        return String.format("WHERE U.name = \'%s\'", this.name);
    }
}
