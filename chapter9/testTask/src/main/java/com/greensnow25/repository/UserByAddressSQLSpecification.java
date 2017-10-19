package com.greensnow25.repository;

/**
 * Public class SearchUserByAddress.
 *
 * @author greensnow25.
 * @version 1.
 * @since 13.10.2017.
 */
public class UserByAddressSQLSpecification implements SqlSpecification {

    private final String country;
    private final String city;

    public UserByAddressSQLSpecification(String country, String city) {
        this.country = country;
        this.city = city;
    }

    @Override
    public String toSQLQuery() {

        return String.format("WHERE A.country = \'%s\' AND A.city  = \'%s\' ",
                this.country,
                this.city);
    }
}
