package com.greensnow25.entity;

/**
 * Public class Address.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.10.2017.
 */
public class Address {
    /**
     * user country.
     */
    private String country;
    /**
     * user city.
     */
    private String city;
    /**
     * user id.
     */
    private int id;

    public Address(String country, String city, int id) {
        this.country = country;
        this.city = city;
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
