package com.greensnow25.servlets.model;

/**
 * Public class Calculator.
 *
 * @author greensnow25.
 * @version 1.
 * @since 07.09.2017.
 */
public class Calculator {
    /**
     * first number.
     */
    private int first;
    /**
     * second number.
     */
    private int second;
    /**
     * count of operations can be increased.
     */
    private static final int OPERATIONS = 4;
    /**
     * operations.
     */
    private Calc[] operations;

    /**
     * constructor.
     */
    public Calculator() {
        this.operations = new Calc[OPERATIONS];
        addToOperations();

    }

    /**
     * add all existing operations to the array.
     */
    private void addToOperations() {
        int count = 0;
        operations[count++] = new Add();
        operations[count++] = new Submit();
        operations[count++] = new Div();
        operations[count++] = new Multiply();

    }

    /**
     * before execute math operations, you need initialize variables.
     *
     * @param first  variable.
     * @param second variable.
     */
    public void doSome(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * inner class can add numbers.
     */
    private class Add implements Calc {
        /**
         * info.
         *
         * @return info.
         */
        @Override
        public String info() {
            return "add";
        }

        /**
         * do mathOperation.
         *
         * @return result
         */
        @Override
        public int mathOperation() {
            return first + second;
        }
    }

    /**
     * inner class can submit numbers.
     */
    private class Submit implements Calc {
        /**
         * info.
         *
         * @return info.
         */
        @Override
        public String info() {
            return "sub";
        }

        /**
         * do mathOperation.
         *
         * @return result
         */
        @Override
        public int mathOperation() {
            return first - second;
        }
    }

    /**
     * inner class can div numbers.
     */
    private class Div implements Calc {
        /**
         * info.
         *
         * @return info.
         */
        @Override
        public String info() {
            return "div";
        }

        /**
         * do mathOperation.
         *
         * @return result
         */
        @Override
        public int mathOperation() {
            return first / second;
        }
    }

    /**
     * inner class can multiply numbers.
     */
    private class Multiply implements Calc {
        /**
         * info.
         *
         * @return info.
         */
        @Override
        public String info() {
            return "mult";
        }

        /**
         * do mathOperation.
         *
         * @return result
         */
        @Override
        public int mathOperation() {
            return first * second;
        }
    }

    /**
     * getOperations.
     *
     * @return operations.
     */
    public Calc[] getOperations() {
        return operations;
    }
}
