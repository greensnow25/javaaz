package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class UserStoreTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 15.05.2017.
 */
public class UserStoreTest {
    /**
     * class object.
     */
    private UserStore userStore;

  //  private SimpleArray<User> list;

    private User userOne ;
    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
      //  this.list = new SimpleArray();
        this.userStore = new UserStore();
        this.userOne = new User (12);
        userStore.add(userOne);
    }

    /**
     * test user store, add object User.
     */
    @Test
    public void whenAddNewItemToTheUserStoreThenReturnSameItem() {

        User res = userStore.getList().get(0);

        assertThat(res, is(this.userOne));
    }

    /**
     * test remove.
     */
    @Test

    public void whenRemoveUserFromTheStorageThenListSizeDecreasesByOne() {

        userStore.remove(userOne);

        assertThat(userStore.getList().getList().size(), is(0));
    }

    /**
     * test update.
     */
    @Test

    public void whenUpdateItemThenRenurnNewItem() {

        userStore.update((User) userStore.getList().get(0), new User(15));

        assertThat(userStore.getList().getList().get(0), is(15));
    }

}