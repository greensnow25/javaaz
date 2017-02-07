package com.greensnow25.chess;

/**
 * public class Cell.
 * describes the Cell.
 *
 * @author greensnow25.
 * @version 1.
 * @since 30.01.17.
 */
public class Cell {
    /**
     * field describes axis X.
     */
    private int axisX;
    /**
     * field describes axis Y.
     */
    private int axisY;

    /**
     * constructor of class.
     * @param axisX axis X.
     * @param axisY axis Y.
     */
    public Cell(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    /**
     * get axis X
     * @return X.
     */
    public int getAxisX() {
        return axisX;
    }
    /**
     * get axis Y
     * @return Y.
     */
    public int getAxisY() {
        return axisY;
    }

    /**
     * set axis X.
     * @param axisX X.
     */
    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }
    /**
     * set axis Y.
     * @param axisY Y.
     */
    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;

        Cell cell = (Cell) o;

        if (axisX != cell.axisX) return false;
        return axisY == cell.axisY;

    }


}
