package com.greensnow25.decorator;

import com.greensnow25.countingDays.CountingDays;
import com.greensnow25.foods.Food;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;

import java.text.ParseException;

/**
 * public class Recycling.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public class Recycling extends PlaceDecorator {
    /**
     * food array.
     */
    private Food[] foods;

    /**
     * position in tne array.
     */
    private int pos = 0;



    public Recycling(Place place) {
        super(place);
        this.foods = new Food[2];
    }


    /**
     * add food too recycling.
     *
     * @param food food.
     */
    @Override
    public void addFood(Food food) {
        foods[pos++] = food;
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {
        boolean res = super.canAdd(food);
        if (food instanceof RecycleFood) {
            RecycleFood qqq = (RecycleFood) food;
            int count = new CountingDays().qq(food);
            if (count > 100 && qqq.isCanRecycle()) {
                res = true;
            }
        }

        return res;
    }

    public Food[] getFoods() {
        return foods;
    }
}
