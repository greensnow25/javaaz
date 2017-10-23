package com.greensnow25.modules;

/**
 * Public class Car.
 *
 * @author com.greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
public class Car {
    /**
     * id
     */
    private int id;

    /**
     * name.
     */
    private String name;

    /**
     * car body.
     */
    private Body body;
    /**
     * car transmission
     */
    private Transmission transmission;
    /**
     * car engine.
     */
    private Engine engine;
    /**
     * owner user.
     */
    private User user;

    public Car() {
    }

    public Car(String name, Body body, Transmission transmission, Engine engine, User user) {
        this.name = name;
        this.body = body;
        this.transmission = transmission;
        this.engine = engine;
        this.user = user;
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

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
