package com.greensnow25.foods;

/**
 * public class Fruit.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class Fruit extends Food {
    /**
     * class constructor.
     *
     * @param name        name.
     * @param expaireDate date.
     * @param createDate  date.
     * @param prise       prise.
     * @param discount    discount.
     */
    public Fruit(String name, String expaireDate, String createDate, String prise, String discount) {
        super(name, expaireDate, createDate, prise, discount);
    }
}
