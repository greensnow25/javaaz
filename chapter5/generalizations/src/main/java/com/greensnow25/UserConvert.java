package com.greensnow25;

/**
 * public class UserConvert.
 *
 * @author greensnow25.
 * @version 1.
 * @since 05.04.2017.
 */

import java.util.HashMap;
import java.util.List;


public class UserConvert {

    /**
     * method convert list to map.
     * @param list list.
     * @return map.
     */
    public HashMap<Integer, User> process(List<User> list) {
        int count = 1;
        HashMap<Integer, User> map = new HashMap<>();

        for (User user : list) {
            map.put(count++, user);
                    }
        return map;
    }
}
