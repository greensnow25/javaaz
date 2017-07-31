package com.greensnow25.board;

/**
 * public class Figure.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public abstract class Figure {
    /**
     * axis x.
     */
    private int axisX;
    /**
     * axis y.
     */
    private int axisY;

    /**
     * default constructor.
     */
    public Figure() {
    }

    /**
     * constructor.
     *
     * @param axisX axis x.
     * @param axisY axis y.
     */
    public Figure(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    /**
     * get x.
     *
     * @return x.
     */
    public int getAxisX() {
        return axisX;
    }

    /**
     * get y.
     *
     * @return y.
     */
    public int getAxisY() {
        return axisY;
    }

    /**
     * set x.
     * @param axisX x.
     */
    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }
    /**
     * set y.
     * @param axisY y.
     */
    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }
}
