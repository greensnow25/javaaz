package com.greensnow25.decorator;

import com.greensnow25.countingDays.CountingDays;
import com.greensnow25.foods.Food;
import com.greensnow25.foods.Fruit;
import com.greensnow25.storage.Place;

import java.text.ParseException;

/**
 * public class Refregerator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public class Refregerator extends PlaceDecorator {
    private Food[] foods;
    int pos = 0;
    Place place;

    public Refregerator(Place place) {
        super(place);
        this.place = place;

        this.foods = new Food[3];
    }

    @Override
    public void addFood(Food food) {
        this.foods[pos++] = food;
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {
        boolean res = false;
        int count = new CountingDays().qq(food);
        if (food instanceof Fruit && count < 25) {
            res = true;
        } else if (count < 25) {
            place.addFood(food);
        }

        return res;
    }

    public Food[] getFoods() {
        return foods;
    }
}
