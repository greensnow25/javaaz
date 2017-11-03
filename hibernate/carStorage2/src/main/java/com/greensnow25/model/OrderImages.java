package com.greensnow25.model;

import javax.persistence.*;

/**
 * Public class OrderImages.
 *
 * @author greensnow25.
 * @version 1.
 * @since 02.11.2017.
 */
@Entity
@Table(schema = "car_storage")
public class OrderImages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    public OrderImages(Order order) {
        this.order = order;
    }

    public OrderImages(Order order, Image image) {
        this.order = order;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
