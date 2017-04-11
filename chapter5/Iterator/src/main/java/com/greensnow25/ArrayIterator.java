package com.greensnow25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * public class ArrayIterator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.04.2017.
 */
public class ArrayIterator implements Iterator {
    /**
     * array.
     */
    private int[][] array;
    /**
     * row.
     */
    private int i = 0;
    /**
     * colum.
     */
    private int j = 0;

    /**
     * constructor.
     *
     * @param array array.
     */
    public ArrayIterator(int[][] array) {
        this.array = array;
    }


    @Override
    public boolean hasNext() {
        boolean result = true;
        if (i == array.length || j == array[i].length) {
            result = false;
        }
        return result;
    }

    @Override
    public Object next() {
        Integer tmp = this.array[i][j];
        if (i < array.length) {
            if (j == array.length) {
                j = 0;
                i++;
            } else {
                tmp = array[i][j];
                j++;
            }
        }
        return tmp;
    }

}
