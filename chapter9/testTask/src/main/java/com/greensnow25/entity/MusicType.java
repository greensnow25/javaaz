package com.greensnow25.entity;

/**
 * Public class MusicType.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.10.2017.
 */
public class MusicType {
    /**
     * music type.
     */
    private String type;
    /**
     * id.
     */
    private int id;

    public MusicType(String type, int id) {
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
