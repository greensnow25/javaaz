package com.greensnow25.decorator;

import com.greensnow25.foods.Food;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Refregerator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public class Refregerator extends PlaceDecorator {
    /**
     * product storage.
     */
    private List<Food> list;
    /**
     * destination for products.
     */
    private Place place;

    /**
     * class constructor.
     *
     * @param place storage place.
     */
    public Refregerator(Place place) {
        super(place);
        this.place = place;
        this.list = new ArrayList<>();
    }

    /**
     * add food to foods list.
     *
     * @param food food.
     */
 //   @Override
 //   public void addFood(RecycleFood food) {
  //      list.add(food);
  //  }

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
        if (place.canAdd(food) && food.isFreze()) {
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
        return list;
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {
       if(food instanceof RecycleFood){
           return this.canAddR((RecycleFood) food);
       }
        return false;
    }
}
