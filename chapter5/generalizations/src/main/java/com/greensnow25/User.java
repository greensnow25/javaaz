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
     * id.
     */
    private int id;
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
     * @param id   user.
     * @param name user.
     * @param age  user.
     * @param city user.
     */
    public User(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    /**
     * get.
     *
     * @return id.
     */
    public int getId() {
        return id;
    }
}
