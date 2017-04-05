package com.greensnow25;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 05.04.2017.
 */
public class User {
    /**
     * user name.
     */
    private String name;
    /**
     * user age.
     */
    private int age;
    /**
     * user city.
     */
    private String city;

    /**
     * class constructor.
     *
     * @param name user.
     * @param age  user.
     * @param city user.
     */
    public User(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
}
