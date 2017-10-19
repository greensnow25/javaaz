package com.greensnow25.repository;

/**
 * Public class UserByMusicTypeSQLSpecification.
 *
 * @author greensnow25.
 * @version 1.
 * @since 17.10.2017.
 */
public class UserByMusicTypeSQLSpecification implements SqlSpecification {
    /**
     * music type.
     */
    private final String type;

    public UserByMusicTypeSQLSpecification(String type) {
        this.type = type;
    }

    @Override
    public String toSQLQuery() {
        return String.format("WHERE M.type = \'%s\' ", this.type);
    }
}
