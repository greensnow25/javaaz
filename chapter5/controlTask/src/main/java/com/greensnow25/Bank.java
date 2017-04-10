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
    /**
     * map users.
     */
    private Map<User, List<Account>> map;

    /**
     * class object.
     */

    public Bank() {
        this.map = new HashMap<>();

    }

    /**
     * add user.
     *
     * @param user user.
     */
    public void addUser(User user) {

        this.map.put(user, new ArrayList<>());
    }

    /**
     * remoweUser.
     *
     * @param user user.
     */
    public void removeUser(User user) {
        this.map.remove(user);
    }

    /**
     * add account to the user.
     *
     * @param user    user.
     * @param account account.
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> acc = this.map.get(user);
        acc.add(account);
    }

    /**
     * delete account from user.
     *
     * @param user    user.
     * @param account account.
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> acc = this.map.get(user);
        Iterator<Account> iterator = acc.iterator();
        while (iterator.hasNext()) {
            Account accountOne = iterator.next();
            if (account.getRequisites() == accountOne.getRequisites()) {
                iterator.remove();
                break;
            }
        }

    }

    /**
     * getUsers Accounts.
     *
     * @param user user.
     * @return List.
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> account = this.map.get(user);
        return account;
    }

    /**
     * method transfer moneys, if result succses return true.
     *
     * @param srcUser    User who transfers money.
     * @param srcAccount The account from which we transfer the money.
     * @param dstUser    User receives money.
     * @param dstAccount The account for which money comes.
     * @param amount     sum.
     * @return
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean res = false;

        boolean checkFirsUserAndMoneys = this.checkUsers(srcUser, srcAccount, amount);
        boolean checkSecondUser = this.checkUsers(dstUser, dstAccount, 0);
//If user verification is successful, we translate.
        if (checkFirsUserAndMoneys && checkSecondUser) {
            this.transferMoney(srcUser, srcAccount, -amount);
            this.transferMoney(dstUser, dstAccount, amount);
            res = true;
        }
        return res;
    }

    /**
     * User verification. And availability of funds.
     *
     * @param user    user.
     * @param account account.
     * @param amount  amount.
     * @return If user verification is successful, return true.
     */
    public boolean checkUsers(User user, Account account, double amount) {
        boolean result = false;
        List<Account> accOne = this.map.get(user);
        Iterator<Account> iteratorOne = accOne.iterator();
        while (iteratorOne.hasNext()) {
            Account accountOne = iteratorOne.next();
            if (accountOne.getRequisites() == account.getRequisites()) {
                if (accountOne.getValue() >= amount) {
                    result = true;
                } else if (amount == 0) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * transferMoney.
     *
     * @param user    user.
     * @param account account.
     * @param amount  amount.
     */
    public void transferMoney(User user, Account account, double amount) {

        List<Account> accOne = this.map.get(user);
        Iterator<Account> iteratorOne = accOne.iterator();
        while (iteratorOne.hasNext()) {
            Account accountOne = iteratorOne.next();
            if (accountOne.getRequisites() == account.getRequisites()) {
                accountOne.setValue(accountOne.getValue() + amount);
            }
        }

    }

    /**
     * getMap.
     *
     * @return map.
     */
    public Map<User, List<Account>> getMap() {
        return map;
    }
}