package com.greensnow25.decorator;

import com.greensnow25.foods.Food;
import com.greensnow25.storage.Place;
import com.greensnow25.storage.Warehouse;

import java.text.ParseException;

/**
 * public class WarehauseOnce.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.04.2017.
 */
public class WarehauseOnce extends Warehouse implements Place {
    //private Refregerator refregerator;
    private Refregerator[] ref;

    public WarehauseOnce() {
        this.ref = new Refregerator[3];
      //  this.refregerator = new Refregerator(new WarehauseOnce());
    }

    @Override
    public boolean canAdd(Food food) throws ParseException {
        boolean res = super.canAdd(food);
        if(res){

        }

        return super.canAdd(food);
    }
}

