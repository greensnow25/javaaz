package com.greensnow25.modules;

/**
 * Public class User.
 *
 * @author com.greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
public class User {
    /**
     * id
     */
    private int id;

    /**
     * name.
     */
    private String name;

    /**
     * car
     */
    private Car car;

    public User() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
