package com.greensnow25.foodsCanReproduct;

import com.greensnow25.foods.Food;

/**
 * public class RecycleFood.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public abstract class RecycleFood extends Food implements Freze, Reproduct {
    /**
     * class constructor.
     *
     * @param name        name.
     * @param expaireDate date.
     * @param createDate  date.
     * @param prise       prise.
     * @param discount    discount.
     */
    public RecycleFood(String name, String createDate, String expaireDate, String prise, String discount) {
        super(name, createDate, expaireDate, prise, discount);
    }

}
