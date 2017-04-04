package com.greensnow25;

import java.util.ArrayList;
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
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i != array.length; i++) {
            count++;
            for (int j = 0; j <= array[count - 1].length - 1; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }

    /**
     * determine array lenght.
     *
     * @param list list.
     * @return langht.
     */
    public int sizeArray(List<Integer> list) {
        int row = 0;
        int large = list.size();
        for (int i = 1; ; i++) {
            if (Math.pow(i, 2) >= large) {
                row = i;
                break;
            }
        }
        return row;
    }

    /**
     * method transmit list to array.
     *
     * @param list list.
     * @param rows arrays length.
     * @return array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[rows][rows];
        int count = 0;
        for (int i = 0; i != rows; i++) {
            for (int j = 0; j != rows; j++) {
                if (count >= list.size()) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = list.get(count++);
                }
            }
        }
        return array;
    }
}
