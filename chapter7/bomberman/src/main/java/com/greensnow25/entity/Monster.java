package com.greensnow25.entity;

import com.greensnow25.modules.Board;
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
public class Monster extends Entity implements Runnable {
    /**
     * name.
     */
    private final String name;

    /**
     * constructor.
     *
     * @param board board.
     */
    public Monster(Board board, String name) {
        super(board);
        this.name = name;
    }


    /**
     * method generates all possibles moves.
     *
     * @return array, with all possibles moves.
     */
    @Override
    public Cell[] move() {
        Cell[] moves = new Cell[4];
        int count = 0;
        super.generateEntity(this);
        Cell current = super.getCurrentCell();
        moves[count++] = new Cell(current.getAxisX(), current.getAxisY() + 1);
        moves[count++] = new Cell(current.getAxisX(), current.getAxisY() - 1);
        moves[count++] = new Cell(current.getAxisX() + 1, current.getAxisY());
        moves[count++] = new Cell(current.getAxisX() - 1, current.getAxisY());

        return moves;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Cell[] cells = this.move();
        }
    }


}
