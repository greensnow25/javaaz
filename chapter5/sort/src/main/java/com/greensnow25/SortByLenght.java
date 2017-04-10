package com.greensnow25;

import java.util.Comparator;

/**
 * public class SortByLenght.
 *
 * @author greensnow25.
 * @version 1.
 * @since 06.04.2017.
 */
public class SortByLenght implements Comparator<User> {


    @Override
    public int compare(User o1, User o2) {
        int one = o1.getName().length();
        int two = o2.getName().length();

        return Integer.compare(one, two);
    }
}
