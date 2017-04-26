package com.greensnow25;

import java.util.ArrayList;
import java.util.Map;

/**
 * public class ItemOnce.
 *
 * @author greensnow25.
 * @version 1.
 * @since 13.04.2017.
 */
public class ItemOnce implements Item, ItemRename {
    /**
     * item name.
     */
    private String name;
    /**
     * inner items.
     */
    private ArrayList<ItemOnce> items;

    /**
     * constructor.
     *
     * @param name name.
     */
    public ItemOnce(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    /**
     * add Item.
     *
     * @param name item name.
     */
    public void addItem(String name) {
        items.add(new ItemOnce(name));
    }

    /**
     * get name.
     *
     * @return item name.
     */
    public String getName() {
        return name;
    }

    /**
     * get item.
     *
     * @return item.
     */
    public ArrayList<ItemOnce> getItems() {
        return items;
    }

    /**
     * rename item.
     *
     * @param newName new Item name.
     */
    @Override
    public void rename(String newName) {
        this.name = newName;
    }
}
