package com.greensnow25.model;

import javax.persistence.*;

/**
 * Public class Image.
 *
 * @author greensnow25.
 * @version 1.
 * @since 25.10.2017.
 */
@Entity
@Table(schema = "car_storage", name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    //@Lob
    @Column(name = "image")
    private byte[] image;

    public Image() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
