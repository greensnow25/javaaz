package com.greensnow25;

import java.util.*;

/**
 * public class Bank.
 *
 * @author greensnow25.
 * @version 1.
 * @since 06.04.2017.
 */
public class Bank {
    private List<User> user;

    private Map<User, List<Account>> map;


    public Bank() {
        this.map = new TreeMap<>();

    }

    public void addUser(User user) {
        this.map.put(user, null);
    }

    public void removeUser(User user) {
        this.map.remove(user);
    }

    public void addAccountToUser(User user, Account account) {
        List<Account> acc = this.map.get(user);
        acc.add(account);
    }
    public void deleteAccountFromUser(User user, Account account) {

    }
}