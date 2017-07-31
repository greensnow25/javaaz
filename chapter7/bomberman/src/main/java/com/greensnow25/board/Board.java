package com.greensnow25.board;

import com.greensnow25.units.*;

import java.util.concurrent.CyclicBarrier;

/**
 * Public class Board.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Board {
    /**
     * field for game.
     */
    private final Cell[][] board;

    /**
     * flag of boar creating.
     */
    private boolean bordCreate = false;
    /**
     * cycle barrier.
     */
    private CyclicBarrier barrier;

    /**
     * constructor.
     *
     * @param size size of playing field.
     */
    public Board(int size, CyclicBarrier barrier) {
        this.board = new Cell[size][size];
        this.barrier = barrier;
    }


    /**
     * print playing field.
     */
    public void createOrPrintBoard() {
        for (int i = 0; i != board.length; i++) {
            for (int j = 0; j != board[i].length; j++) {
                if (!this.bordCreate) {
                    board[i][j] = new Cell(i, j);
                } else {
                    if (board[i][j].getUnit() == null) {
                        System.out.print(" * ");
                    } else if (board[i][j].getUnit() instanceof Barrier) {
                        System.out.print(" B ");
                    } else if (board[i][j].getUnit() instanceof Monster) {
                        System.out.print(" M ");
                    } else {
                        System.out.print(" P ");
                    }
                }
            }
            System.out.print(System.getProperty("line.separator"));
        }
        System.out.print(System.getProperty("line.separator"));
        this.bordCreate = true;
    }

    /**
     * set unit in the cell.
     *
     * @param futureCell future cell.
     * @param Unit     unit.
     * @param oldCell    old cell.
     */
    public void setOnTheBoard(Cell futureCell, Unit Unit, Cell oldCell) {
        board[oldCell.getAxisX()][oldCell.getAxisY()].setUnit(null);
        board[futureCell.getAxisX()][futureCell.getAxisY()].setUnit(Unit);

    }

    /**
     * get Board.
     *
     * @return board.
     */
    public Cell[][] getBoard() {
        return board;
    }

    /**
     * get CycleBarrier.
     *
     * @return barrier.
     */
    public CyclicBarrier getBarrier() {
        return barrier;
    }
}
