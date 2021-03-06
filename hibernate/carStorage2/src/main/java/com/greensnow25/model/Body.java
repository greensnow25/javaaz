package com.greensnow25.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Public class Body.
 *
 * @author com.greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
@Entity
@Table(schema = "car_storage", name = "body_car")
public class Body {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_body")
    private int id;

    /**
     * name.
     */
    @Column(name = "name_body")
    private String name;

    /**
     * car
     */
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "body")
     private transient Set<Car> cars;

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
