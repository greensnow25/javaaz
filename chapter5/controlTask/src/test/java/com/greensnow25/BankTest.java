package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class BankTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.04.2017.
 */
public class BankTest {
    /**
     * class object;
     */
    private Bank bank;
    /**
     * class object;
     */
    private User userOne;
    /**
     * class object;
     */
    private User userTwo;
    /**
     * class object;
     */
    private Account one;
    /**
     * class object;
     */
    private Account two;


    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.bank = new Bank();
        this.userOne = new User("ivan", "123");
        this.userTwo = new User("inna", "321");
        this.one = new Account(123, 100);
        this.two = new Account(321, 25);

    }

    /**
     * test transfer. if transfer succses, retur true.
     */
    @Test
    public void whenTransferSucsesThenReturnTrue() {
        this.bank.addUser(this.userOne);
        this.bank.addUser(this.userTwo);
        this.bank.addAccountToUser(this.userOne, one);
        this.bank.addAccountToUser(this.userTwo, two);

        boolean result = bank.transferMoney(userOne, one, userTwo, two, 45);

        assertTrue(result);

    }

    /**
     * test transfer. if transfer succses, retur true.
     */
    @Test
    public void whenTransferSucsesThenShowBalance() {
        double result = -1;
        this.bank.addUser(this.userOne);
        this.bank.addUser(this.userTwo);
        this.bank.addAccountToUser(this.userOne, one);
        this.bank.addAccountToUser(this.userTwo, two);

        bank.transferMoney(userOne, one, userTwo, two, 45);
        List<Account> accounts = bank.getMap().get(this.userTwo);
        Iterator<Account> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            if (account.getRequisites() == two.getRequisites()) {
                result = account.getValue();
            }
        }
        assertThat(result, is(70d));

    }

    /**
     * Insufficient funds for translation.
     */
    @Test
    public void whenTransferSucsesThenReturnFalse() {
        this.bank.addUser(this.userOne);
        this.bank.addUser(this.userTwo);
        this.bank.addAccountToUser(this.userOne, one);
        this.bank.addAccountToUser(this.userTwo, two);

        boolean result = bank.transferMoney(userOne, one, userTwo, two, 150);

        assertFalse(result);
    }
}