package com.greensnow25;

import com.greensnow25.foods.Food;
import java.text.ParseException;

/**
 * public class ControlQuality.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class ControlQuality {
    /**
     * array of storage.
     */
    private Place[] places;
    /**
     * array of products.
     */
    private Food[] foods;
    /**
     * position in places array.
     */
    private int position = 0;
    /**
     * position in food array.
     */
    private int coutFoods = 0;

    /**
     * default constructor.
     */
    public ControlQuality() {
        this.places = new Place[3];
        this.foods = new Food[4];
    }

    /**
     * add storage.
     *
     * @param place storage.
     */
    public void addPlaces(Place place) {
        this.places[position++] = place;
    }

    /**
     * add products to the array.
     *
     * @param food product.
     */
    public void addFoods(Food food) {
        this.foods[coutFoods++] = food;
    }

    /**
     * move product t storage.
     *
     * @param foods  product.
     * @param places storage.
     * @throws ParseException ex.
     */
    public void move(Food[] foods, Place[] places) throws ParseException {
        for (Place place : places) {
            for (Food food : foods) {
                if (place.canAdd(food) && food != null) {
                    place.addFood(food);
                }
            }
        }
    }

    public Place[] getPlaces() {
        return places;
    }

    public Food[] getFoods() {
        return foods;
    }
}



