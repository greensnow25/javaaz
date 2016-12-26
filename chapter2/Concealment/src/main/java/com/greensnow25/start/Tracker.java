package com.greensnow25.start;

import com.greensnow25.modules.*;
import java.util.Random;


/**
 * Created by on 23.12.2016.
 */
public class Tracker {
    private Item[] items = new Item[10];
    private int position = 0;
    private static final Random RN = new Random();

    public Item add (Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    protected Item findById(String id) {
    Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    public Item[] getAll() {
        Item[] result = new Item [this.position];
        for (int index = 0; index!= this.position;index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    public void update(Item item) {
        this.add(findById(item.getId()));
    }

    public void delete(Item item, String name) {
        for (int index = 0; index <= items.length - 1; index++) {
            if (this.items[index] != null && item.getName().equals(findByName(name))){
               this.items[index] = null;
            }
        }


    }
    public Item findByName(String key) {
        Item result = null;
            for (Item item : items) {
                if (item !=null && item.getName().equals(key)) {
                    result = item;
                    break;
                }
            }
        return result;
    }
}
