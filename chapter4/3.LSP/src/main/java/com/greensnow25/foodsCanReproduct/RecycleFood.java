package com.greensnow25.foodsCanReproduct;

import com.greensnow25.foods.Food;

/**
 * public class RecycleFood.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public class RecycleFood extends Food {
    /**
     * can recycle.
     */
    private boolean canRecycle = false;

    /**
     * class constructor.
     *
     * @param name        name.
     * @param expaireDate date.
     * @param createDate  date.
     * @param prise       prise.
     * @param discount    discount.
     * @param canRecycle can recycle.
     */
    public RecycleFood(String name, String createDate, String expaireDate, String prise, String discount, boolean canRecycle) {
        super(name, createDate, expaireDate, prise, discount);
        this.canRecycle = canRecycle;
    }

    public boolean isCanRecycle() {
        return canRecycle;
    }
}
