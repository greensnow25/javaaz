package com.greensnow25;

import com.greensnow25.foods.Food;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;

import java.text.ParseException;

/**
 * public class ControlQualityOnce.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.04.2017.
 */
public class ControlQualityOnce implements ControlQulityOnce {


    @Override
    public void move(Place[] places, RecycleFood[] food) throws ParseException {
        for(Place place : places){
            for(Food foods : food){
                place.canAdd(foods);
            }
        }
    }
}
