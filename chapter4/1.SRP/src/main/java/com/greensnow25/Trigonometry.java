package com.greensnow25;

import com.greensnow25.input.Input;

/**
 * public class Trigonometry.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.03.2017.
 */
public class Trigonometry extends InteractCalculator {
    private double result;

    /**
     * class constructor.
     *
     * @param input input system.
     */
    public Trigonometry(Input input) {
        super(input);
    }

    public class Sin implements CalculatorAction {

        String pattern = "(\\w+[^0-9]+){1}(\\d*)";

        String result;

        @Override
        public double makeAction(double one, double two) {

            return  Math.sin(two);
        }
    }
    public class Cos implements CalculatorAction{

        @Override
        public double makeAction(double one, double two) {
            return Math.cos(two);
        }
    }
    public class Tan implements CalculatorAction{

        @Override
        public double makeAction(double one, double two) {
            return Math.tan(two);
        }
    }
    public class CoTan implements CalculatorAction{

        @Override
        public double makeAction(double one, double two) {
            return Math.atan(two);
        }
    }
    enum Operations {
        SIN("sin"),
        COS("cos"),
        TAN("tan"),
        COTAN("ctg");
        private String name;
        Operations(String name){
            this.name = name;
        }

    }
}
