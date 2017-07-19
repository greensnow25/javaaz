package com.greensnow25.entity;

import com.greensnow25.modules.Cell;

/**
 * Public class MyMonsterTwo.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class MyMonsterTwo extends Monster {
    /**
     * constructor.
     *
     * @param name monster name.
     */
    public MyMonsterTwo(String name) {
        super(name);
    }

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
