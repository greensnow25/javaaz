package com.greensnow25.modules;

import com.greensnow25.entity.Entity;

/**
 * Public class Cell.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Cell {
    private int axisX;
    private int axisY;

    private Entity entity;

    public Cell(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    public void addNewEntity(Entity entity) {
        if (entity == null) {
            this.entity = entity;
        } else {
            System.out.println("This cell already busy");
        }

    }

    public int getAxisX() {
        return axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "axisX=" + axisX +
                ", axisY=" + axisY +
                ", entity=" + entity +
                '}';
    }
}
