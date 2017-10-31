package com.greensnow25.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Public class Model.
 *
 * @author greensnow25.
 * @version 1.
 * @since 30.10.2017.
 */
@Entity
@Table(schema = "car_storage", name = "model")
public class Model implements Serializable {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int id;

    /**
     * model.
     */
    @Column(name = "model_name")
    private String model;

    /**
     * brand.
     */
    @Column(name = "brand_name")
    private String brand;
    /**
     * car
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private transient Set<Car> cars;


    public Model(String model) {
        this.model = model;
    }

    public Model() {
    }

    public Model(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
