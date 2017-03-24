package com.greensnow25;

import com.greensnow25.input.Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * public class Trigonometry.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.03.2017.
 */
public class Trigonometry extends InteractCalculator {
    private double result;
    String pattern  ="(\\w+[^0-9]+){1}(\\d*)";
    /**
     * class constructor.
     *
     * @param input input system.
     */
    public Trigonometry(Input input) {
        super(input);
    }




}
