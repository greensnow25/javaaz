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
     * Method converts a list of arrays into an integer sequence.
     *
     * @param list of arrays.
     * @return integer sequence.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> res = new ArrayList<>();
        for (int[] array:list){
            for(int i : array){
                res.add(i);
            }
        }
        return res;
    }
}
