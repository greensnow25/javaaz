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
public class Monster implements Entity {
    /**
     * name.
     */
    private final String name;

    /**
     * constructor.
     *
     * @param name monster name.
     */
    public Monster(String name) {
        this.name = name;
    }

    /**
     * method generates all possibles moves.
     * @param currentPosition monster.
     * @return array, with all possibles moves.
     */
    @Override
    public Cell[] move(Cell currentPosition) {
        Cell[] moves = new Cell[4];
        int count = 0;
        moves[count++] = new Cell(currentPosition.getAxisX(),currentPosition.getAxisY()+1);
        moves[count++] = new Cell(currentPosition.getAxisX(),currentPosition.getAxisY()-1);
        moves[count++] = new Cell(currentPosition.getAxisX()+1,currentPosition.getAxisY());
        moves[count++] = new Cell(currentPosition.getAxisX()-1,currentPosition.getAxisY());

        return moves;
    }
}
