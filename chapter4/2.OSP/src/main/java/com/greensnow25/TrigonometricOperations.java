package com.greensnow25;

/**
 * public class TrigonometricOperations.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.03.2017.
 */
public enum TrigonometricOperations {
    SIN("sin") {
        @Override
        public double makeTrigOper(double two) {
            return Math.sin(two);
        }
    },
    COS("cos") {
        @Override
        public double makeTrigOper(double two) {
            return Math.cos(two);
        }
    },
    TAN("tan") {
        @Override
        public double makeTrigOper(double two) {
            return Math.tan(two);
        }
    },
    COTAN("ctg") {
        @Override
        public double makeTrigOper(double two) {
            return Math.atan(two);
        }
    };
    private String name;
    public abstract double makeTrigOper(double two);
    TrigonometricOperations(String name){
        this.name = name;
    }
}
