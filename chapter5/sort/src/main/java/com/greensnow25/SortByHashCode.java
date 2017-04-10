package com.greensnow25;

import java.util.Comparator;

/**
 * public class SortByHashCode.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.04.2017.
 */
public class SortByHashCode implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.hashCode() - o2.hashCode();
    }
}
