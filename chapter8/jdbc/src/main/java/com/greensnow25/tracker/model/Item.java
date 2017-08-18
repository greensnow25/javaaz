package com.greensnow25.tracker.model;

import com.greensnow25.tracker.database.MyCommentBase;

/**
 * public class Item contain fields of item.
 *
 * @author greensnow25.
 * @version 1.0.
 * @since 27.12.16.
 */
public class Item {
    /**
     * field of class.
     */
    private InterfaceComment comments;
    /**
     * item id.
     */
    private String id;
    /**
     * item name.
     */
    private String name;
    /**
     * item description.
     */
    private String discription;
    /**
     * item create date.
     */
    private long create;

    /**
     * public constructor of class Item.
     *
     * @param name        item name.
     * @param description description of Item.
     * @param create      creating time.
     */

    public Item(String name, String description, long create) {
        this.name = name;
        this.discription = description;
        this.create = create;
    }

    /**
     * public constructor of class Item.
     *
     * @param name        item name.
     * @param description description of Item.
     */
    public Item(String name, String description) {
        this.comments = new MyCommentBase();
        this.name = name;
        this.discription = description;
    }

    /**
     * default constructor of class.
     */
    public Item() {
    }

    /**
     * getName.
     *
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getDiscription.
     *
     * @return discription.
     */
    public String getDiscription() {

        return this.discription;
    }

    /**
     * getId.
     *
     * @return Id.
     */
    public String getId() {

        return this.id;
    }

    /**
     * setID.
     *
     * @param id string.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * set name.
     *
     * @param name string.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get.
     *
     * @return comment realization.
     */
    public InterfaceComment getComments() {
        return comments;
    }

    /**
     * toString.
     *
     * @return String.
     */
    @Override
    public String toString() {
        return "Item{" +
                "comments=" + comments +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", create=" + create +
                '}';
    }
}


