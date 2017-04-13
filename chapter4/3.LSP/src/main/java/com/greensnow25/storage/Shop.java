package com.greensnow25.storage;

import com.greensnow25.countingDays.CountingDays;
import com.greensnow25.foods.Food;

import java.text.ParseException;

/**
 * public class Shop.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class Shop implements Place {
    /**
     * position in food array.
     */
    private int position = 0;
    /**
     * food array.
     */
    private Food[] food = new Food[10];

    /**
     * getFood.
     *
     * @return food array.
     */
    public Food[] getFood() {
        return food;
    }

    /**
     * setFood.
     *
     * @param food food.
     */
    public void setFood(Food[] food) {
        this.food = food;
    }

    /**
     * add food.
     *
     * @param food food.
     */
    public void addFood(Food food) {
        this.food[position++] = food;
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {
        boolean res = false;
        int count = new CountingDays().qq(food);
        if (count > 25 && count < 75) {
            res = true;
        } else if (count > 75 && count < 100) {
            food.setDisscount("30%");
            res = true;
        }

        return res;
    }

}
