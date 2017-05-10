package com.greensnow25.EvenNumbers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * public class EvenNumbers.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.04.2017.
 */
public class EvenNumbers implements Iterator {
    /**
     * array
     */
    private final int[] array;
    /**
     * position in the array.
     */
    int value = 0;

    /**
     * class constructor.
     *
     * @param array int array.
     */
    public EvenNumbers(int[] array) {
        this.array = array;
    }

    /**
     * the method checks whether the array contains a number that is divisible by two.
     *
     * @return true if array contain the even number..
     */
    @Override
    public boolean hasNext() {

        boolean result = false;
        for (int i = value; i != array.length; i++) {
            if (array[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * the method checks whether the array contains a number that is divisible by two.
     *
     * @return even number.
     */
    @Override
    public Object next() {
        Integer res = 0;
        for (int i = value; ; i++) {
            if (array[i] % 2 == 0) {
                res = array[i];
                value = ++i;
                break;
            }
        }
        return res;
    }

}
