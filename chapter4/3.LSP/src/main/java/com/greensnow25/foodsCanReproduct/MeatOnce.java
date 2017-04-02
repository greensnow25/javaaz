package com.greensnow25.foodsCanReproduct;

/**
 * public class MeatOnce.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public class MeatOnce extends RecycleFood {
    /**
     * class constructor.
     *
     * @param name        name.
     * @param createDate  date.
     * @param expaireDate date.
     * @param prise       prise.
     * @param discount    discount.
     * @param canRecycle  can recycle.
     */
    public MeatOnce(String name, String createDate, String expaireDate, String prise, String discount, boolean canRecycle) {
        super(name, createDate, expaireDate, prise, discount, canRecycle);
    }
}
