package com.greensnow25.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Public class Transmission.
 *
 * @author com.greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
@Entity
@Table(schema = "car_storage", name = "transmission")
public class Transmission {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car_transmit")
    private int id;

    /**
     * name.
     */
    @Column(name = "name_transmition")
    private String name;

    /**
     * car
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transmission")
    private transient Set<Car> cars;

    public Transmission() {
    }

    public Transmission(String name) {
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
