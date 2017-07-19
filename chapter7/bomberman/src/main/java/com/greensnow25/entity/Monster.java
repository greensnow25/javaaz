package com.greensnow25.entity;

import com.greensnow25.modules.Cell;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Public class Monster.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
@Immutable
public abstract class Monster extends Entity {
    /**
     * name.
     */
    private final String name;

    /**
     * constructor.
     *
     * @param name monster name.
     */
    protected Monster(String name) {
        this.name = name;
    }

    /**
     * method move monster.
     */
    @Override
    public abstract Cell[] move(Cell currentPosition);
}
