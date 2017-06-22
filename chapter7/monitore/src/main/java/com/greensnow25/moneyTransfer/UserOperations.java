package com.greensnow25.moneyTransfer;

/**
 * public class UserOperations.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.06.2017.
 */
public abstract class UserOperations {

    int key;

    private String info;

    public UserOperations(String info, int key) {
        this.info = info;
        this.key = key;
    }

    /**
     * do something operation with user.
     *
     * @return true if operation is success, else false.
     */
    public abstract boolean doSomething();

    /**
     * print info.
     */
    public void info() {
        System.out.println(this.info);
    }

    public int key(){
        return this.key;
    }
}
