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

    /**
     * sort list with help Comparator. Sort by hash code.
     *
     * @param list no sorted list.
     * @return sorted list.
     */
    public List<User> sortHash(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        return list;
    }

    /**
     * sort list with help Comparator. Sort by length name.
     *
     * @param list no sorted list.
     * @return sorted list.
     */
    public List<User> sortLanght(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int one = o1.getName().length();
                int two = o2.getName().length();

                return Integer.compare(one, two);
            }
        });
        return list;
    }

}
