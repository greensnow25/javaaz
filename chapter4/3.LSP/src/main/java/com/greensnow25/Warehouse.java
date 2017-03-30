package com.greensnow25;

import com.greensnow25.countingDays.CountingDays;
import com.greensnow25.foods.Food;

import java.text.ParseException;

/**
 * public class Warehouse.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class Warehouse implements Place {
    /**
     * position in food array.
     */
    private int positin = 0;
    /**
     * food array.
     */
    private Food[] food = new Food[10];

    /**
     * add food.
     *
     * @param food food.
     */
    @Override
    public void addFood(Food food) {
        this.food[positin++] = food;
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {
        boolean res = false;
        int count = new CountingDays().qq(food);
        if (count<=25){
            res = true;
        }
        return res;
    }

    public Food[] getFood() {
        return food;
    }
}
