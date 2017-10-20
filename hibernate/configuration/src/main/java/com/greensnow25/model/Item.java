package com.greensnow25.model;

import java.sql.Timestamp;

/**
 * Public class Item.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.10.2017.
 */
public class Item {
    /**
     * id.
     */
    private int id;
    /**
     * desc.
     */
    private String desc;
    /**
     * date of created.
     */
    private Timestamp created;
    /**
     * processes performed.
     */
    private boolean done;

    public Item() {
    }

    public Item(String desc, Timestamp created, boolean done) {
        this.desc = desc;
        this.created = created;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
