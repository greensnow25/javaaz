package com.greensnow25.EvenNumbers;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class EvenNumbersTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.04.2017.
 */
public class EvenNumbersTest {
    /**
     * list.
     */
    private int[] array;
    /**
     * class object.
     */
    private EvenNumbers evenNumbers;


    @Before
    public void beforeTheTest() {
        this.array = new int[10];
        for (int i = 0; i != array.length; i++) {
            array[i] = i;
        }
        this.evenNumbers = new EvenNumbers(array);

    }

    /**
     * next test.
     */
    @Test
    public void whenTwoCallNextThenReturnFour () {
        int result = 0;
        evenNumbers.next();
        result = (Integer) evenNumbers.next();

        assertThat(result, is(4));

    }

    /**
     * next test.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenFiveCallNextThenReturnExeption () {
        for (int i =0; i<7;i++){
            evenNumbers.next();
        }




    }
}