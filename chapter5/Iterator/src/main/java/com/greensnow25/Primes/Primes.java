package com.greensnow25.Primes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * public class Primes.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.05.2017.
 */
public class Primes implements Iterator {
    /**
     * array.
     */
    private final int[] arrray;

    /**
     * position.
     */
    private int position = 0;

    /**
     * constructor.
     *
     * @param arrray
     */
    public Primes(int[] arrray) {
        this.arrray = arrray;
    }

    /**
     * method checks contain array more primes.
     *
     * @return true if contain.
     */
    @Override
    public boolean hasNext() {
        return this.check() > 0;

    }

    /**
     * method return prime number, and move pointer to one wright.
     *
     * @return prime number.
     */
    @Override
    public Object next() {
        this.check();
        return (Integer) arrray[position++];

    }

    /**
     * method generate dividers for number.
     *
     * @param number number.
     * @return list of dividers, of the number.
     */
    public List<Integer> createDividers(int number) {
        ArrayList<Integer> dividers = new ArrayList<>();
        int res = (int) Math.ceil(Math.sqrt(number));
        for (int i = 2; i <= res; i++) {
            if (i % 2 != 0) {
                dividers.add(i);
            }
        }
        return dividers;
    }


    /**
     * method move pointer on position.
     *
     * @return position in array.
     */
    public int check() {
        for (int i = position; i != arrray.length; i++) {
            if (arrray[i] == 2 || arrray[i] == 3) {
                position = i;
                return 1;
            } else if (arrray[i] % 2 != 0) {
                List<Integer> divi = this.createDividers(arrray[i]);
                int size = 0;
                for (Integer j : divi) {
                    if (arrray[i] % j != 0) {
                        size++;
                    }
                    if (size == divi.size()) {
                        position = i;
                        return 1;
                    }
                }
            }
        }
        return -1;
    }
}
