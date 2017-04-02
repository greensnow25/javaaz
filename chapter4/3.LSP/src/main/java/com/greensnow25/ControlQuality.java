package com.greensnow25;

import com.greensnow25.foods.Food;
import com.greensnow25.storage.Place;

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
     * position in places array.
     */
    private int position = 0;

    /**
     * default constructor.
     */
    public ControlQuality() {
        this.places = new Place[5];

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

}



