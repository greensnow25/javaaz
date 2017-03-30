package com.greensnow25.countingDays;

import com.greensnow25.foods.Food;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * public class CountingDays.
 *
 * @author greensnow25.
 * @version 1.
 * @since 30.03.2017.
 */
public class CountingDays {
    /**
     * @return percents.
     * @throws ParseException ex.
     */
    public int qq(Food food) throws ParseException {
        Date date = new Date();
        SimpleDateFormat simple = new SimpleDateFormat("dd.MM.yy");
        String currentDay = simple.format(date);
        Date create = simple.parse(food.getCreateDate());
        Date expaire = simple.parse(food.getExpaireDate());
        Date curretn = simple.parse(currentDay);
        long exToCrDate = expaire.getTime() - create.getTime();
        long curToCrDate = curretn.getTime() - create.getTime();
        int daysOne = (int) (exToCrDate / (24 * 60 * 60 * 1000));
        int daysTWo = (int) (curToCrDate / (24 * 60 * 60 * 1000));
        return daysTWo * 100 / daysOne;

    }


}
