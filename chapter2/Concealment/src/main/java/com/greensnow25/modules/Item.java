package com.greensnow25.modules;

/**
 * public class Item contain fields of item.
 * @author greensnow25.
 * @since 27.12.16.
 * @version 1.0.
 */
public class Item {
    /**
     * item id.
     */
    private String id;
    /**
     * item name.
     */
    private String name;
    /**
     * item discription.
     */
    private String discription;
    /**
     * item create date.
     */
    private long create;
    /**
     * public constructor of class Item.
     * @param name item name.
     * @param discription description of Item.
     * @param create creating time.
     */

  public Item(String name, String discription, long create) {
      this.name = name;
      this.discription = discription;
      this.create = create;
  }

    /**
     * public constructor of class Item.
     * @param name item name.
     * @param discription description of Item.
     */
    public Item(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }
    public  Item () {

    }

    /**
     * getName.
     * @return name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getDiscription.
     * @return discription.
     */
    public String getDiscription() {

        return this.discription;
    }

    /**
     * getCreate.
     * @return create.
     */
    public long getCreate() {

        return this.create;
    }

    /**
     * getId.
     * @return Id.
     */
    public String getId() {

        return this.id;
    }

    /**
     * setID.
     * @param id string.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * set name.
     * @param name string.
     */
    public void setName(String name) {
        this.name = name;
    }

}

