package com.greensnow25.entity;

import com.greensnow25.modules.Cell;

/**
 * Public class Entity.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public interface Entity {
    /**
     * move object.
     *
     * @param currentPosition current position.
     * @return array of all possibles moves.
     */
    Cell[] move(Cell currentPosition);

}
