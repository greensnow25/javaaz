package com.greensnow25;

import com.greensnow25.foods.Food;

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

    /**
     * setFood.
     * @param food food.
     */
    public void setFood(Food[] food) {
        this.food = food;
    }
}
