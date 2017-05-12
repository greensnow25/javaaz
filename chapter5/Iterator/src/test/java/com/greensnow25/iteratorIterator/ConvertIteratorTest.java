package com.greensnow25.iteratorIterator;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * public class ConvertIteratorTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.05.в2017.
 */
public class ConvertIteratorTest {

    /**
     * class object.
     */
    ConvertIterator convertIterator;


    /**
     * method run before each the test.
     */
    @Before
    public void beforeTheTest() {
        Iterator<Integer> itOne = Arrays.asList(1, 2, 3).iterator();
        Iterator<Integer> itTwo = Arrays.asList(4, 5).iterator();
        Iterator<Integer> itThree = Arrays.asList(6, 7, 8, 9).iterator();
        ArrayList<Iterator<Integer>> iterators = new ArrayList<>();
        iterators.add(itOne);
        iterators.add(itTwo);
        iterators.add(itThree);
        Iterator<Iterator<Integer>> iterator = iterators.iterator();
        this.convertIterator = new ConvertIterator(iterator);
    }

    /**
     * test next. when call next twice then return two.
     */
    @Test
    public void whenCallNextTwiceThenReturnTwo() {
        convertIterator.next();
        int res = convertIterator.next();

        assertThat(res, is(2));
    }

    /**
     * test next. when eight calls next then return two.
     */

    @Test
    public void whenEightCallsNextThenReturnEight() {
        int res = 0;
        for (int i = 0; i != 8; i++) {
            res = convertIterator.next();
        }
        assertThat(res, is(8));
    }

    /**
     * test next. when ten calls next then return Exception..
     */

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenTenCallsNextThenReturnException() {

        for (int i = 0; i != 10; i++) {
            this.convertIterator.next();
        }
    }

    /**
     * test hasNext. when call hasNext return true.
     */
    @Test
    public void whenThreeCallsNextAndHasNextThenReturnTrue() {
        boolean res = false;
        for (int i = 0; i != 2; i++) {
            this.convertIterator.next();
        }
        res = convertIterator.hasNext();
        assertTrue(res);
    }

    /**
     * test hasNext. when call hasNext return false.
     */
    @Test
    public void whenNineCallsNextAndHasNextThenReturnFalse() {
        boolean res = false;
        for (int i = 0; i != 9; i++) {
            this.convertIterator.next();
        }
        res = convertIterator.hasNext();
        assertFalse(res);
    }

}