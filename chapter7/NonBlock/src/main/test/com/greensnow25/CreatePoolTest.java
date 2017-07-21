package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Public class CreatePoolTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.07.2017.
 */
public class CreatePoolTest {
    /**
     * class object.
     */
    private CreatePool pool;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() throws Exception {
        this.pool = new CreatePool();
        pool.createPool();
    }

    /**
     * when add all tasks to the cache then collection size equals 100;
     *
     * @throws Exception
     */
    @Test
    public void whenAddThenSizeEquals100() {

        int size = pool.getNb().getMap().size();
        assertThat(size, is(100));
    }

    /**
     * when update task then increment task version.
     *
     * @throws Exception
     */
    @Test
    public void whenUpdateThenReturnNewTask() throws Exception {
        pool.getNb().update(22, new Task(225, "Jeri", 0));
        int version = pool.getNb().getMap().get(22).getVersion();
        assertThat(version, is(1));
    }

    /**
     * when delete task then return null.
     */
    @Test
    public void whenDeleteThenReturnNull() {
        pool.getNb().remove(10);
        assertNull(pool.getNb().getMap().get(10));


    }

}