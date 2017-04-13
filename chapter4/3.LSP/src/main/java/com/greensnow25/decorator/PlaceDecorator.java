package com.greensnow25.decorator;

import com.greensnow25.foods.Food;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;
import com.greensnow25.storage.Warehouse;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * public class PlaceDecorator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public abstract class PlaceDecorator implements Place {
    /**
     * storage type.
     */
    private Place place;

    /**
     * class constructor.
     *
     * @param place storage.
     */
    public PlaceDecorator(Place place) {
        this.place = place;
    }

    /**
     * abstract method add food.
     *
     * @param food food.
     */
    public abstract void addFood(RecycleFood food);

    /**
     * method check, can you add fod to the storage.
     *
     * @param food food.
     * @return boolean.
     * @throws ParseException exception.
     */
    public abstract boolean canAddR(RecycleFood food) throws ParseException;

    /**
     * if you want use this method you must override there.
     *
     * @param food food.
     */
    @Override
    public void addFood(Food food) {
        System.out.println("You need override method");
    }

    /**
     * if you want use this method you must override there.
     *
     * @param food food.
     */
    @Override
    public boolean canAdd(Food food) throws ParseException {
        System.out.println("You need override method");
        return false;
    }
}
