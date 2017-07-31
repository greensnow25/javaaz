package com.greensnow25.modules;

import com.greensnow25.entity.Entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Public class Cell.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Cell extends ReentrantLock {
    /**
     * axis X.
     */
    private int axisX;
    /**
     * axis Y.
     */
    private int axisY;
    /**
     * Unit on the current position.
     */
    private Entity entity;

    /**
     * constructor.
     *
     * @param axisX X.
     * @param axisY Y.
     */
    public Cell(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    /**
     * get axis X.
     *
     * @return X.
     */
    public int getAxisX() {
        return axisX;
    }

    /**
     * get axis Y.
     *
     * @return Y
     */
    public int getAxisY() {
        return axisY;
    }

    /**
     * get unit.
     *
     * @return unit.
     */
    public Entity getEntity() {
        return entity;
    }

    /**
     * set unit.
     *
     * @param entity unit.
     */
    public void setEntity(Entity entity) {
        this.entity = entity;
    }


}
