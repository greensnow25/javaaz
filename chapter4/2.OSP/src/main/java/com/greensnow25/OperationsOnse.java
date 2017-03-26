package com.greensnow25;

/**
 * public class OperationsOnse.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.03.2017.
 */
public enum OperationsOnse{
    /**
     * add.
     */
    ADD("+") {
        @Override
        public double makeAction(double one, double two) {
           calculator.add(one,two);
            return calculator.result;
        }
    },
    /**
     * sub.
     */
    SUB("-") {
        @Override
        public double makeAction(double one, double two) {
            calculator.substract(one,two);
            return calculator.result;
        }
    },
    /**
     * split.
     */
    SPLIT("/") {
        @Override
        public double makeAction(double one, double two) {
           calculator.div(one,two);
            return calculator.result;
        }
    },
    /**
     * myltiply.
     */
    MYLTIPLY("*") {
        @Override
        public double makeAction(double one, double two) {
            calculator.multiple(one,two);
            return calculator.result;
        }
    };

    /**
     * kind of operation.
     */
    private String operation;

    public abstract double makeAction(double one, double two);

    /**
     * enum cons.
     *
     * @param operation key.
     */
    OperationsOnse(String operation) {
        this.operation = operation;
    }
        Calculator calculator = new Calculator();

    public String getOperation() {
        return operation;
    }

}
