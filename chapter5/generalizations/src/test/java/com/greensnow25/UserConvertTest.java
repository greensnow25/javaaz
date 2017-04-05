package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class UserConvertTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 05.04.2017.
 */
public class UserConvertTest {
    /**
     * user number one.
     */
    private User userOne;
    /**
     * user number two.
     */
    private User userTvo;
    /**
     * user number three.
     */
    private User userThree;
    /**
     * class object.
     */
    private UserConvert userConvert;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.userOne = new User(1,"Gleb", 20, "kiev");
        this.userTvo = new User(2,"Ivan", 30, "moscow");
        this.userThree = new User(3,"Vasiliy", 40, "bern");
        this.userConvert = new UserConvert();

    }

    /**
     * method create list.
     * @return list.
     */
    public List<User> addUsersToList() {
        List<User> users = new ArrayList<>();
        users.add(this.userOne);
        users.add(this.userTvo);
        users.add(this.userThree);
        return users;
    }

    /**
     * convert to map.
     */
    @Test
    public void whenTransmitUserListThenReturnMap() {

        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, this.userOne);
        expected.put(2, this.userTvo);
        expected.put(3, this.userThree);


        assertThat(expected, is(userConvert.process(this.addUsersToList())));
    }

}