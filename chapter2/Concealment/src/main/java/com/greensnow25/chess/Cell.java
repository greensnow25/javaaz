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
    private String axisX;
    /**
     * field describes axis Y.
     */
    private String axisY;

    /**
     * constructor of class.
     * @param axisX axis X.
     * @param axisY axis Y.
     */
    public Cell(String axisX, String axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    /**
     * get axis X
     * @return X.
     */
    public String getAxisX() {
        return axisX;
    }
    /**
     * get axis Y
     * @return Y.
     */
    public String getAxisY() {
        return axisY;
    }

    /**
     * set axis X.
     * @param axisX X.
     */
    public void setAxisX(String axisX) {
        this.axisX = axisX;
    }
    /**
     * set axis Y.
     * @param axisY Y.
     */
    public void setAxisY(String axisY) {
        this.axisY = axisY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;

        Cell cell = (Cell) o;

        if (!axisX.equals(cell.axisX)) return false;
        return axisY.equals(cell.axisY);

    }

    @Override
    public int hashCode() {
        int result = axisX.hashCode();
        result = 31 * result + axisY.hashCode();
        return result;
    }
}
