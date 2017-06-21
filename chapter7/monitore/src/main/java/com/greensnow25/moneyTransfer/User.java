package com.greensnow25.moneyTransfer;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.06.2017.
 */
public class User {
    /**
     * user name.
     */
    private final String name;

    /**
     * Account balance.
     */
    private int amount;

    /**
     * constructor.
     * @param name user name.
     * @param amount balance.
     */
    public User(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (amount != user.amount) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }
}
