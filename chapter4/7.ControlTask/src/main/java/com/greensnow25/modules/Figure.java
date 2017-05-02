package com.greensnow25.modules;

/**
 * public class Figure.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public abstract class Figure {
    private int axisX;
    private int axisY;

    public Figure(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public int getAxisX() {
        return axisX;
    }

    public int getAxisY() {
        return axisY;
    }
}
