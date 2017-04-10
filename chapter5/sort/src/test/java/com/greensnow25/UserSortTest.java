package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * public class UserSortTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 06.04.2017.
 */
public class UserSortTest {
    /**
     * class object.
     */
    private UserSort userSort;
    /**
     * user one.
     */
    private User user;
    /**
     * user two
     */
    private User userOne;

    /**
     * user two.
     */
    private User userTwo;

    /**
     * user three.
     */
    private User userThree;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.userSort = new UserSort();
        this.user = new User(14, "pol");
        this.userOne = new User(34, "jack");
        this.userTwo = new User(52, "jo");
        this.userThree = new User(53, "jo");

    }

    /**
     * create list.
     *
     * @return list.
     */
    public List<User> makeList() {
        List<User> list = new ArrayList<>();
        list.add(userOne);
        list.add(user);
        list.add(userTwo);
        list.add(userThree);
        return list;
    }

    /**
     * test sort when sort wright return true.
     */
    @Test
    public void whenTransmitListReturnSortTreeSet() {
        boolean res = true;
        int count = 0;
        List<User> list = this.makeList();
        Set<User> set = this.userSort.sort(list);

        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (count <= user.getAge()) {
                count = user.getAge();
            } else {
                res = false;
                break;
            }
            System.out.println(user.getAge() + "  " + user.getName());
        }

        assertTrue(res);
    }

    /**
     * sort by hash code.
     */
    @Test
    public void whenSortListThenSortByHashCode() {
        boolean res = true;
        int count = 0;
        List<User> list = this.makeList();
        List<User> users = this.userSort.sortHash(list);

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (count <= user.hashCode()) {
                count = user.hashCode();
            } else {
                res = false;
                break;
            }
            System.out.println(user.hashCode() + "  " + user.getAge() + "  " + user.getName());
        }
        assertTrue(res);
    }

    /**
     * sort by length name.
     */
    @Test
    public void whenSortListThenSortByLenghtName() {
        boolean res = true;
        int count = 0;
        List<User> list = this.makeList();
        List<User> users = this.userSort.sortLanght(list);

        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (count <= user.getName().length()) {
                count = user.getName().length();
            } else {
                res = false;
                break;
            }
            System.out.println(user.getAge() + "  " + user.getName());
        }
        assertTrue(res);
    }
}