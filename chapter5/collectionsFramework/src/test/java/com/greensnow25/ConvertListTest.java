package com.greensnow25;

import org.junit.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class ConvertListTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.04.2017.
 */
public class ConvertListTest {
    /**
     * class object.
     */
    ConvertList convertList;
    /**
     * array.
     */
    private final int[][] ARRAY = new int[][]{{1, 2, 3},
            {4, 5, 6},
            {7}};

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.convertList = new ConvertList();

    }

    /**
     * Transmit array to list.
     */
    @org.junit.Test
    public void whenTransmitArrayThenGetList() {
        List<Integer> list = this.convertList.toList(this.ARRAY);
        List<Integer> expected = new ArrayList<>();
        for (int i = 1; i != list.size() + 1; i++) {
            expected.add(i - 1, i);
        }
        assertThat(expected, is(list));
    }

    /**
     * Transmit list to array.
     */
    @Test
    public void whenTransmitListThenGetArray() {

        int rows = 5;
        int len = 2;
        int count = 1;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i != 10 + 1; i++) {
            list.add(i - 1, i);
        }

        int expected[][] = new int[rows][len];
        for (int i = 0; i != rows; i++) {
            for (int j = 0; j != len; j++) {
                expected[i][j] = count++;
            }
        }

        int[][] actual = this.convertList.toArray(list, 5);


        assertThat(actual, is(expected));
    }
}