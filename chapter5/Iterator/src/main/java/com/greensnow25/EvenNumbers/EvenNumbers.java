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

        return this.check() > 0;
    }

    /**
     * the method checks whether the array contains a number that is divisible by two.
     *
     * @return even number.
     */
    @Override
    public Object next() {
        this.check();
        return (Integer) array[value++];
    }

    /**
     * method move pointer on position.
     *
     * @return position in array.
     */
    public int check() {
        int res = -1;
        for (int i = value; i != array.length; i++) {
            if (array[i] % 2 == 0) {
                value = i;
                res = 1;
                break;
            }
        }
        return res;
    }
}
