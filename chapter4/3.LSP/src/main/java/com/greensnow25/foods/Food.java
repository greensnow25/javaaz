package com.greensnow25.foods;

/**
 * public class Food.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public abstract class Food {
    /**
     * food name.
     */
    private String name;
    /**
     * expaire Date.
     */
    private String expaireDate;
    /**
     * create date.
     */
    private String createDate;
    /**
     * prise.
     */
    private String prise;
    /**
     * disscount.
     */
    private String disscount = null;

    /**
     * class constructor.
     *
     * @param name        name.
     * @param expaireDate date.
     * @param createDate  date.
     * @param prise       prise.
     * @param discount    discount.
     */
    public Food(String name, String createDate, String expaireDate, String prise, String discount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.prise = prise;
        this.disscount = discount;
    }

    /**
     * default constructor.
     */
    public Food() {
    }


    /**
     * getName.
     *
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * getExpaireDate.
     *
     * @return ExpaireDate.
     */
    public String getExpaireDate() {
        return expaireDate;
    }

    /**
     * getCreateDate.
     *
     * @return CreateDate.
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * getPrise.
     *
     * @return Prise.
     */
    public String getPrise() {
        return prise;
    }

    /**
     * getDisscount.
     *
     * @return Disscount.
     */
    public String getDisscount() {
        return disscount;
    }

    /**
     * set.
     * @param disscount set.
     */
    public void setDisscount(String disscount) {
        this.disscount = disscount;
    }


}
