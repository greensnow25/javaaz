package com.greensnow25;

import java.util.*;

/**
 * public class UserSort.
 *
 * @author greensnow25.
 * @version 1.
 * @since 05.04.2017.
 */
public class UserSort {

    /**
     * sort list with help Comparable.
     *
     * @param list no sorted list.
     * @return sorted treeSet.
     */
    public Set<User> sort(List<User> list) {
        Set<User> treeSet = new TreeSet<>();
        treeSet.addAll(list);

        return treeSet;

    }


}
