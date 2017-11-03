package com.greensnow25.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Public class User.
 *
 * @author com.greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
@Entity
@Table(schema = "car_storage", name = "user")
public class User {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    /**
     * name.
     */
    @Column(name = "user_name")
    private String name;

    /**
     * password.
     */
    @Column(name = "password")
    private String password;
    /**
     * car
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private transient Set<Car> cars;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
