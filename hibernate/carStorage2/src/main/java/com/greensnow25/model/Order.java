package com.greensnow25.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Public class Order.
 *
 * @author greensnow25.
 * @version 1.
 * @since 02.11.2017.
 */
@Entity
@Table(schema = "car_storage", name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car carId;

    @Column(name = "name_order")
    private String name;
    @Column(name = "sold")
    private boolean sold;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private transient Set<OrderImages> orderImages;

    public Order() {
    }

    public Order(Car carId, String name, boolean sold) {
        this.carId = carId;
        this.name = name;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Set<OrderImages> getOrderImages() {
        return orderImages;
    }

    public void setOrderImages(Set<OrderImages> orderImages) {
        this.orderImages = orderImages;
    }
}
