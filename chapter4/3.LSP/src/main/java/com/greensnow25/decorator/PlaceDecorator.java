package com.greensnow25.decorator;

import com.greensnow25.storage.Place;

/**
 * public class PlaceDecorator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 31.03.2017.
 */
public abstract class PlaceDecorator implements Place {
        private Place place;

    public PlaceDecorator(Place place) {
        this.place = place;
    }


}
