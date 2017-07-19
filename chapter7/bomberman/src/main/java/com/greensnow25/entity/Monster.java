package com.greensnow25.entity;

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Public class Monster.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
@Immutable
public abstract class Monster {
    /**
     * name.
     */
    private final String name;

    /**
     * constructor.
     * @param name monster name.
     */
    protected Monster(String name) {
        this.name = name;
    }

    /**
     * method move monster.
     */
    public abstract void move();
}
