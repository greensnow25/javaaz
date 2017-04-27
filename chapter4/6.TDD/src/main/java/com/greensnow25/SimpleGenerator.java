package com.greensnow25;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * public class SimpleGeerator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class SimpleGenerator {

    public String generate(String sentence, Map<String, String> map) throws Bag {
        String result = sentence;
        Pattern pattern = Pattern.compile("\\$\\{{1}[\\w]*\\}");
        Matcher matcher = pattern.matcher(sentence);
        List<String> list = new ArrayList<>();

        while (matcher.find()) {
            String key = matcher.group();
            list.add(key);
            String value = map.get(key);
            if (value == null) {
                throw new Bag("no key in the map");
            }
            result = result.replace(key, value);
        }
        ArrayList<String> keyList = new ArrayList<>(map.keySet());

        if (!keyList.equals(list)) {
            throw new Bag("Extra keys found");
        }

        return result;
    }


}

