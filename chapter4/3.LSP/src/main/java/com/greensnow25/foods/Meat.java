package com.greensnow25.foods;

/**
 * public class Meat.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class Meat extends Food {
    /**
     * class constructor.
     *
     * @param name        name.
     * @param expaireDate date.
     * @param createDate  date.
     * @param prise       prise.
     *                    * @param discount    discount.
     */
    public Meat(String name, String createDate, String expaireDate, String prise, String discount) {
        super(name, createDate, expaireDate, prise, discount);
    }
}
