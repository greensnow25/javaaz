package com.greensnow25.model;

import java.util.Set;

/**
 * Public class Body.
 *
 * @author com.greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
public class Body {
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
    private Set<Car> cars;

    public Body() {
    }

    public Body(String name) {
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

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
