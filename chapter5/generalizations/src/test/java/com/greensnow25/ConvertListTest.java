package com.greensnow25;

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
 * @since 05.04.2017.
 */
public class ConvertListTest {
    /**
     * array one.
     */
    private final int[] ONE = new int[]{1, 2, 3};
    /**
     * array two.
     */
    private final int[] TWO = new int[]{4, 5, 6, 7, 8};
    /**
     * array three.
     */
    private final int[] THREE = new int[]{9, 10};

    /**
     * convert test.
     */
    @Test
    public void whenTpansmitlistOfArraysTheReturnIntegrList() {
        ConvertList convertList = new ConvertList();
        List<int[]> list = new ArrayList<>();
        list.add(ONE);
        list.add(TWO);
        list.add(THREE);
        List<Integer> expected = new ArrayList<>();
        for (int i = 0; i != 10; i++) {
            expected.add(i, i + 1);
        }
        assertThat(expected, is(convertList.convert(list)));
    }
}