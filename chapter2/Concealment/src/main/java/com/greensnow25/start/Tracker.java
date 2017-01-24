package com.greensnow25.start;

import com.greensnow25.modules.Item;
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
     * sizearray.
     */
    private final int sizeArray = 10;
    /**
     * array of items.
     */
    private Item[] items = new Item[sizeArray];


    /**
     * position.
     */
    private int position = 0;
    /**
     * const.
     */
    private static final Random RN = new Random();

    /**
     * Method add the Item.
     *
     * @param item item.
     * @return item onposition.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * Methos search item by id.
     *
     * @param id of item.
     * @return finded item.
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
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }

    /**
     * Metod search item and update them.
     *
     * @param item you want to find.
     */
    public void update(Item item) {
        for (int index = 0; index != this.items.length; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
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

        for (int index = 0; index != this.items.length; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(item.getId())) {
                this.items[index] = null;
                System.arraycopy(items, index + 1, items, index, items.length - index - 1);
                position--;
                break;
            }
        }


    }

    /**
     * Method search item by name.
     *
     * @param name - name of item.
     * @return finded item.
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

  /**  public void addComment(String id, Comment comment) {

       Item item =findById(id);
        comment.aDDCOMENT(findById(id).ge);






    }*/

    /**
     * get Item[].
     * @return aray of Items.
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * get position.
     * @return position.
     */
    public int getPosition() {
        return position;
    }



}
