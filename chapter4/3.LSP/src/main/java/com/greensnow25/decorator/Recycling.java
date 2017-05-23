package com.greensnow25.decorator;

import com.greensnow25.foods.Food;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Recycling.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public class Recycling extends PlaceDecorator {
    /**
     * food list..
     */
    private List<Food> foods;
    /**
     * destination for products.
     */
    private Place place;

    /**
     * class constructor.
     *
     * @param place storage place.
     */
    public Recycling(Place place) {
        super(place);
        this.place = place;
        this.foods = new ArrayList<>();
    }

    /**
     * add food to foods list.
     *
     * @param food food.
     */
    @Override
    public void addFood(Food food) {
        foods.add(food);

    }

    /**
     * method check, can you add fod to the storage.
     *
     * @param food food.
     * @return if can may put food on the storage return true.
     * @throws ParseException exception.
     */
    @Override
    public boolean canAddR(RecycleFood food) throws ParseException {
        boolean result = false;
        if (place.canAdd(food) && food.isReproduct()) {
            result = true;
        }
        return result;
    }

    /**
     * get list.
     *
     * @return food list.
     */
    public List<Food> getList() {
        return foods;
    }


    @Override
    public boolean canAdd(Food food) throws ParseException {
        boolean result = false;
        if (food instanceof RecycleFood) {
            RecycleFood recycleFood = (RecycleFood) food;
            if (recycleFood.isReproduct()) {
                result = true;
            }
            result = true;
        }
        return result;
    }
}
