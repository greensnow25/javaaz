package com.greensnow25.modules;

/**
 * Created by
 */
public class Item {
    private String id;
    public String name;
    public String discription;
    public long create;
    private String position = "0";
  public Item (String name, String discription, long create) {
      this.name = name;
      this.discription = discription;
      this.create = create;
  }

    public Item() {
    }

    public String getName() {
        return this.name;
    }

    public String getDiscription() {

        return this.discription;
    }

    public long getCreate() {

        return this.create;
    }

    public String getId() {

        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}

