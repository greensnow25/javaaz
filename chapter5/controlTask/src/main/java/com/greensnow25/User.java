package com.greensnow25;

import java.util.List;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 06.04.2017.
 */
public class User {
    /**
     * user name.
     */
    private String name;
    /**
     * user pasport.
     */
    private String pasport;
    /**
     * account.
     */
    private List<Account> account;

    /**
     * class constructor.
     *
     * @param name    user.
     * @param pasport user.
     */
    public User(String name, String pasport) {
        this.name = name;
        this.pasport = pasport;
    }
    /**
     * class constructor one.
     *
     * @param name    user.
     * @param pasport user.
     */
    public User(String name, String pasport, Account account) {
        this.name = name;
        this.pasport = pasport;
        this.account.add(account);
    }

    public void addAccount(Account account){
        this.account.add(account);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (pasport != null ? !pasport.equals(user.pasport) : user.pasport != null) return false;
        return account != null ? account.equals(user.account) : user.account == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (pasport != null ? pasport.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }
}
