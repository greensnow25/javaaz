package com.greensnow25;

import com.greensnow25.countingDays.CountingDays;
import com.greensnow25.foods.Food;

import java.text.ParseException;

/**
 * public class Trash.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class Trash implements Place {
    /**
     * position in food array.
     */
    private int position = 0;
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
        this.food[position++] = food;
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {
        boolean res = false;
        int count = new CountingDays().qq(food);
        if (count>=100){
            res = true;
        }
        return res;
    }

    public Food[] getFood() {
        return food;
    }
}
