package com.greensnow25;

import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Place;

import java.text.ParseException;

/**
 * public class ControlQulityOnce.
 *
 * @author greensnow25.
 * @version 1.
 * @since 03.04.2017.
 */
public interface ControlQulityOnce {
    /**
     * foods.
     * @param food foods.
     * @param places place.
     */
    void move(Place[] places, RecycleFood[] food) throws ParseException;
}
