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

    Iterator<Integer> itOne;
    Iterator<Integer> itTwo;
    Iterator<Integer> itThree;

    ConvertIterator convertIterator;

    ArrayList<Iterator<Integer>> iterators;
    Iterator<Iterator<Integer>> iterator;

    @Before

    public void beforeTheTest() {
        this.itOne = Arrays.asList(1, 2, 3).iterator();
        this.itTwo = Arrays.asList(4, 5).iterator();
        this.itThree = Arrays.asList(6, 7, 8, 9).iterator();

        this.iterator = Arrays.asList(itOne, itTwo, itThree).iterator();
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
    public void whenThreeCallsNextAndHasNextThenReturnTrue(){
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
    public void whenNineCallsNextAndHasNextThenReturnFalse(){
        boolean res = false;
        for (int i = 0; i != 9; i++) {
            this.convertIterator.next();
        }
        res = convertIterator.hasNext();
        assertFalse(res);
    }

}