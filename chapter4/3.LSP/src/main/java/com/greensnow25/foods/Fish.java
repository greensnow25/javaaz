package com.greensnow25.foods;

/**
 * public class Fish.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class Fish extends Food {
    /**
     * class constructor.
     *
     * @param name        name.
     * @param expaireDate date.
     * @param createDate  date.
     * @param prise       prise.
     * @param discount    discount.
     */
    public Fish(String name, String createDate, String expaireDate, String prise, String discount) {
        super(name, createDate, expaireDate, prise, discount);
    }

}
