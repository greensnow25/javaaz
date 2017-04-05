package com.greensnow25.decorator;

import com.greensnow25.foods.Food;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;

import java.text.ParseException;

/**
 * public class PlaceDecorator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public abstract class PlaceDecorator implements Place {
        private Place place;
    private RecycleFood rFood;

    public PlaceDecorator(Place place) {
        this.place = place;
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {

        return this.place.canAdd(food);
    }
}
