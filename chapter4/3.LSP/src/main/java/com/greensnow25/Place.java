package com.greensnow25;

import com.greensnow25.foods.Food;

import java.text.ParseException;

/**
 * public class Place.
 *
 * @author greensnow25.
 * @version 1.
 * @since 28.03.2017.
 */
public interface Place {
    /**
     * add food.
     *
     * @param food food.
     */
    void addFood(Food food);

    /**
     * can add food in this storage.
     * @param food food.
     * @return if can that true.
     */
    boolean canAdd(Food food) throws ParseException;
}
