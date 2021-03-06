package com.greensnow25.repository;

/**
 * Public class SQLSpecificationImpl.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public class UserByIdSQLSpecification implements SqlSpecification {
    /**
     * user id.
     */
    private int id;

    public UserByIdSQLSpecification(final int id) {
        this.id = id;
    }

    @Override
    public String toSQLQuery() {
        return String.format(
                "WHERE U.id_user = \'%s\'",
                this.id
        );
    }

}
