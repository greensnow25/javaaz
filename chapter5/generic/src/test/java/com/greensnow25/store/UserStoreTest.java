package com.greensnow25.store;

import com.greensnow25.Role;
import com.greensnow25.SimpleArray;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * public class UserStoreTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class UserStoreTest {


    @Test
    public void whenAddItemReturnSameItem(){
        UserStore userStore = new UserStore(new SimpleArray());
        Role role = new Role(12);
        userStore.add(role);
    }

}