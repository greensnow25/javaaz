
package com.greensnow25;

/**
 * class Calculator.
 *
 * @author greensnow25.
 * @version 2.
 * @since 24.03.17.
 */
class Calculator {
    /**
     * result.
     */
    public double result;

    /**
     * add.
     *
     * @param first  number.
     * @param second number.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * substract.
     *
     * @param first  number.
     * @param second number.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * div.
     *
     * @param first  number.
     * @param second number.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * multiply.
     *
     * @param first  number.
     * @param second number.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }
}
 