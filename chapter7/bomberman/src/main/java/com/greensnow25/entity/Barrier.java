package com.greensnow25.entity;

import com.greensnow25.modules.Cell;

/**
 * Public class Barrier.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Barrier extends Entity {

    /**
     * barrier can not move, always return null;
     *
     * @return
     */
    @Override
    public Cell[] move(Cell currentPosition) {
        return null;
    }
}
