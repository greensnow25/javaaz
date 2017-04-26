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

    private int[] array;
    private int result = 0;
    int i = 0;

    public EvenNumbers(int[] array) {
        this.array = array;
    }


    @Override
    public boolean hasNext() {

        boolean result = false;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
       for ()
            if (array[i] % 2 == 0 && result != 0) {
                result = i;

            }

        return result;
    }

}
