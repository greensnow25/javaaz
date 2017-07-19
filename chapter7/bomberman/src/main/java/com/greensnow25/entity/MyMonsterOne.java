package com.greensnow25.entity;

import com.greensnow25.modules.Cell;

/**
 * Public class MyMonsterOne.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class MyMonsterOne extends Monster {
    private final int[] num = new int[]{-1, 1};

    /**
     * constructor.
     *
     * @param name monster name.
     */
    protected MyMonsterOne(String name) {
        super(name);
    }

    @Override
    public Cell[] move(Cell currentPosition) {
//        Cell cell = super.getStartPosition();
//        Cell[] moves = new Cell[4];
//        int count = 0;
//        for (int i : num) {
//            for (int j : num) {
//                moves[count++] = new Cell(cell.getAxisX() + i, cell.getAxisY() + j);
//            }
//        }
//        return moves;
//    }
        return null;
    }
}