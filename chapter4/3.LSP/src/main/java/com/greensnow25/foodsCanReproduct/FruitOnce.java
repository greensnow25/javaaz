package com.greensnow25.foodsCanReproduct;

import com.greensnow25.foods.Food;

/**
 * public class FruitOnce.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public class FruitOnce extends RecycleFood {
    /**
     * class constructor.
     *
     * @param name        name.
     * @param createDate  date.
     * @param expaireDate date.
     * @param prise       prise.
     * @param discount    discount.
     */
    public FruitOnce(String name, String createDate, String expaireDate, String prise, String discount) {
        super(name, createDate, expaireDate, prise, discount);
    }

    @Override
    public boolean isFreze() {
        return true;
    }

    @Override
    public boolean isReproduct() {
        return false;
    }
}
