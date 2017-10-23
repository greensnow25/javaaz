package com.greensnow25.modules;

/**
 * Public class Engine.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
public class Engine {
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

    public Engine() {
    }

    public Engine(String name, Car car) {
        this.name = name;
        this.car = car;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
