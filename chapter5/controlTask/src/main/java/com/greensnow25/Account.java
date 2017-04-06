package com.greensnow25;

/**
 * public class Account.
 *
 * @author greensnow25.
 * @version 1.
 * @since 06.04.2017.
 */
public class Account {
    /**
     * amount of money
     */
    private int value;

    /**
     * Account number.
     */
    private int requisites;

    /**
     * class constructor.
     * @param requisites account number.
     * @param value money.
     */
    public Account(int requisites, int value){
        this.requisites = requisites;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }
}
