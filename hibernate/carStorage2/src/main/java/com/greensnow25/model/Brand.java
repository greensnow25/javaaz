package com.greensnow25.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Public class Brand.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.10.2017.
 */
@Entity
@Table(schema = "car_storage", name = "brand")
public class Brand implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand")
    private int id;

    /**
     * name.
     */
    @Column(name = "name_brand")
    private String name;

    @OneToMany(cascade = ALL,
            mappedBy = "brands")
    private transient  Set<Car> carSet = new HashSet<Car>();

    public Brand(String name) {
        this.name = name;
    }

    public Brand() {
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

    public Set<Car> getCarSet() {
        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }
}
