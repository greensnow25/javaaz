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

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.userStore = new UserStore();
        userStore.add(new User(12));
    }

    /**
     * test user store, add object User.
     */
    @Test
    public void whenAddNewItemToTheUserStoreThenReturnSameItem() {

        int res = userStore.getList().get(0).getId();

        assertThat(res, is(12));
    }

    /**
     * test remove.
     */
    @Test

    public void whenRemoveUserFromTheStorageThenListSizeDecreasesByOne() {

        userStore.remove(userStore.getList().getList().get(0));

        assertThat(userStore.getList().getList().size(), is(0));
    }

    /**
     * test update.
     */
    @Test

    public void whenUpdateItemThenRenurnNewItem() {

        userStore.update(userStore.getList().get(0), new User(15));

        assertThat(userStore.getList().get(0).getId(), is(15));
    }

    /**
     * When we add an extraneous class, it does not add and when the element is returned it returns null.
     */
    @Test

    public void whenAddRoleThenRoleDoNotAdd() {
        Role role = new Role(1);
        userStore.add(role);

        assertNull(userStore.getList().search(role));

    }


}