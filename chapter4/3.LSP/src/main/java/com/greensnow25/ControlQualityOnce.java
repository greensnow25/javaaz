package com.greensnow25;

import com.greensnow25.decorator.PlaceDecorator;
import com.greensnow25.foods.Food;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * public class ControlQualityOnce.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.04.2017.
 */
public class ControlQualityOnce {

    /**
     * array of new storage.
     */
    private List<PlaceDecorator> placeDecor;
    /**
     * array of storage.
     */
    private List<Place> place;

    /**
     * default constructor.
     */
    public ControlQualityOnce() {
        this.placeDecor = new ArrayList<>();
        this.place = new ArrayList<>();

    }

    /**
     * add storage.
     *
     * @param place storage.
     */
    public void addPlaces(Place place) {
        this.place.add(place);
    }

    public void addPleceDecor(PlaceDecorator place) {
        this.placeDecor.add(place);
    }


    public void move(List<Food> food) throws ParseException {
        for (Place place : this.place) {
            for (Food foods : food) {
                if (place.canAdd(foods)) {
                    place.addFood(foods);
                }

            }
        }
    }

    public void moveOne(List<RecycleFood> foods) throws ParseException {
        for (PlaceDecorator place : this.placeDecor) {
            for (RecycleFood food : foods) {
                if (place != null) {
                    if (place.canAddR(food)) {
                        place.addFood(food);
                    }
                }
            }

        }
    }

    public List<PlaceDecorator> getPlaces() {
        return placeDecor;
    }
}
