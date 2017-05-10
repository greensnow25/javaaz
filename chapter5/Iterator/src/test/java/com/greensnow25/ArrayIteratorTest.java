package com.greensnow25;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class ArrayIteratorTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.04.2017.
 */
public class ArrayIteratorTest {
    /**
     * class object.
     */
    private ArrayIterator iterator;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        int[][] array = new int[][]{{1, 2, 3}, {4, 5, 6}};
        this.iterator = new ArrayIterator(array);
    }

    /**
     * next test.
     */
    @Test
    public void whenTransmitArrayThenReturnNumericalSequence() {
        int res = 0;
        for (int i = 0; i < 6; i++) {
            res = (Integer) iterator.next();
        }
        assertThat(res, is(6));


    }

    /**
     * exception test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCallsNextMoreSixThenReturnExeption() {
        for (int i = 0; i < 7; i++) {
            iterator.next();
        }
    }

    /**
     * hasNext return true.
     */
    @Test
    public void whenCallHasHextThenReturnTrue() {
        boolean res = false;
        for (int i = 0; i < 4; i++) {
            iterator.next();
        }
        res = iterator.hasNext();
        assertTrue(res);
    }

    /**
     * hasNext return false.
     */
    @Test
    public void whenCallHasNextMoreFiveThenReturnFalse() {
        boolean res;
        for (int i = 0; i < 6; i++) {
            iterator.next();
        }
        res = iterator.hasNext();
        assertFalse(res);
    }

}