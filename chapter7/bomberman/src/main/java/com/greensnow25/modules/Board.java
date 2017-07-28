package com.greensnow25.modules;

import com.greensnow25.entity.*;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
     * constructor.
     *
     * @param size          size of playing field.
     * @param countMonsters count of monsters.
     */
    public Board(int size, int countMonsters) {
        this.size = size;
        this.lock = new ReentrantLock(true);
        monstersStorage = new Cell[countMonsters];
        this.board = new Cell[size][size];
    }


    /**
     * print playing field.
     */
    public void createAndPrintBoard() {
        for (int i = 0; i != board.length; i++) {
            for (int j = 0; j != board[i].length; j++) {
                if (!this.bordCreate) {
                    board[i][j] = new Cell(i, j);
                } else {
                    if (board[i][j].getEntity() == null) {
                        System.out.print(" * ");
                    } else if (board[i][j].getEntity() instanceof Barrier) {
                        System.out.print(" B ");
                    } else if (board[i][j].getEntity() instanceof Monster) {
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

    public Cell[][] getBoard() {
        return board;
    }

}
