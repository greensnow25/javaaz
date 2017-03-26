package com.greensnow25;

/**
 * public class TrigonometricOperations.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.03.2017.
 */
public enum TrigonometricOperations {
    /**
     * sinus.
     */
    SIN("sin") {
        @Override
        public double makeTrigOper(double two) {
            return Math.sin(two);
        }
    },
    /**
     * cosinus.
     */
    COS("cos") {
        @Override
        public double makeTrigOper(double two) {
            return Math.cos(two);
        }
    },
    /**
     * tangents.
     */
    TAN("tg") {
        @Override
        public double makeTrigOper(double two) {
            return Math.tan(two);
        }
    },
    /**
     * cotangents.
     */
    COTAN("ctg") {
        @Override
        public double makeTrigOper(double two) {
            return Math.atan(two);
        }
    };
    /**
     * name.
     */
    private String name;

    /**
     * trigonometric action.
     * @param two number.
     * @return result.
     */
    public abstract double makeTrigOper(double two);

    /**
     * enum constructor.
     * @param name operation.
     */
    TrigonometricOperations(String name){
        this.name = name;
    }

    /**
     * get name.
     * @return name.
     */
    public String getName() {
        return name;
    }
}
