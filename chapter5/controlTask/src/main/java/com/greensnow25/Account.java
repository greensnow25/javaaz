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
    private double value;

    /**
     * Account number.
     */
    private int requisites;

    /**
     * class constructor.
     *
     * @param requisites account number.
     * @param value      money.
     */
    public Account(int requisites, int value) {
        this.requisites = requisites;
        this.value = value;
    }

    /**
     * getValue.
     *
     * @return value.
     */
    public double getValue() {
        return value;
    }

    /**
     * getValue.
     *
     * @param value value.
     */
    public void setValue(double value) {
        this.value = value;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return requisites == account.requisites;

    }

    @Override
    public int hashCode() {
        return requisites;
    }
}
