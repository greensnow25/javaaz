package com.greensnow25.tracker.start;

import com.greensnow25.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * public Class Tracker create repository of items and methods perfom actions above then.
 *
 * @author gretnsnoow25.
 * @version 1.0.
 * @since 27.12.16.
 */
public class Tracker {

    /**
     * size of array.
     */
    private final int sizeArray = 10;
    /**
     * array of items.
     */
    private List<Item> items = new ArrayList<>(this.sizeArray);

    /**
     * const.
     */
    private static final Random RN = new Random();

    /**
     * Method add the Item.
     *
     * @param item item.
     * @return item on position.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Method search item by id.
     *
     * @param id of item.
     * @return detected item.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method generate id for item.
     *
     * @return id.
     */
    public String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Method show all items.
     *
     * @return array of items.
     */
    public List<Item> getAll() {
        List<Item> result = this.items;
        return result;
    }

    /**
     * Method search item and update them.
     *
     * @param item you want to find.
     */
    public void update(Item item) {
        for (int index = 0; index != this.items.size(); index++) {
            if (this.items.get(index) != null && this.items.get(index).getId().equals(item.getId())) {
                this.items.add(index, item);
                break;
            }
        }
    }

    /**
     * Method search and delete item.
     *
     * @param item which need to delete.
     */
    public void delete(Item item) {

        for (Item item1 : items) {
            if (item1.getId().equals(item.getId())) {
                items.remove(item);
                break;
            }
        }
    }

    /**
     * Method search item by name.
     *
     * @param name - name of item.
     * @return detected item.
     */
    public Item findByName(String name) {
        Item res = null;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                res = item;
                break;
            }
        }
        return res;
    }
}
