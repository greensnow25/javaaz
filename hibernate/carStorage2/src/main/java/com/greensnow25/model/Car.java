package com.greensnow25.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * Public class Car.
 *
 * @author com.greensnow25.
 * @version 1.
 * @since 23.10.2017.
 */
@Entity
@Table(schema = "car_storage", name = "car")
public class Car implements Serializable {
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
    @Column(name = "car_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brands;

    /**
     * car body.
     */
    @ManyToOne
    @JoinColumn(name = "body_id")
    private Body body;
    /**
     * car transmission
     */
    @ManyToOne
    @JoinColumn(name = "transmition_id")
    private Transmission transmission;
    /**
     * car engine.
     */
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;
    /**
     * model.
     */
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    /**
     * owner user.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * car
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carId")
    private transient Set<Order> orders;


//    @ManyToOne
//    @JoinColumn(name = "immage_id")
//    private Image image;
    ;
    /**
     * price.
     */
    private int price;

    public Car() {
    }

    public Car(String name, Brand brands, Body body, Transmission transmission, Engine engine, Model model, User user, int price) {
        this.name = name;
        this.brands = brands;
        this.body = body;
        this.transmission = transmission;
        this.engine = engine;
        this.model = model;
        this.user = user;
        this.price = price;
    }

//    public Image getImage() {
//        return image;
//    }
//
//    public void setImage(Image image) {
//        this.image = image;
//    }

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brands;
    }

    public void setBrand(Brand brand) {
        this.brands = brand;
    }

    public Brand getBrands() {
        return brands;
    }

    public void setBrands(Brand brands) {
        this.brands = brands;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
