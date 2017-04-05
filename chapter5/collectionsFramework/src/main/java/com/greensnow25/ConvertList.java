package com.greensnow25;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * public class ConvertList.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.04.2017.
 */
public class ConvertList {


    /**
     * method transmit array to list.
     *
     * @param array array
     * @return list.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    /**
     * method transmit list to array.
     *
     * @param list list.
     * @param rows arrays length.
     * @return array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int count = 0;
        int len = list.size() / rows;
        if (list.size() % rows != 0) {
            len += 1;
        }
        int[][] array = new int[rows][len];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i != rows; i++) {
            for (int j = 0; j != len; j++) {
                if (count >= list.size()) {
                    array[i][j] = 0;
                } else {
                    while (iterator.hasNext()) {
                        array[i][j] = list.get(iterator.next()-1);
                        break;
                    }

                }
            }
        }
        return array;
    }
}
