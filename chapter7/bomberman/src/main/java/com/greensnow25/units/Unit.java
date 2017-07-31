package com.greensnow25.units;

import com.greensnow25.input.Input;
import com.greensnow25.board.Board;
import com.greensnow25.board.Cell;
import com.greensnow25.validateData.ValidateData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;

/**
 * Public class Unit.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public abstract class Unit implements Runnable {
    /**
     * playing board.
     */
    private final Board board;
    /**
     * current Cell.
     */
    private Cell currentCell;
    /**
     * system input.
     */
    private final Input input;

    /**
     * constructor.
     *
     * @param board board.
     * @param input
     */
    public Unit(Board board, Input input) {
        this.board = board;
        this.input = input;
        this.generateUnit(this);
    }

    /**
     * method generate once units.
     *
     * @param Unit for game.
     */
    private void generateUnit(Unit Unit) {
        while (true) {
            int x = (int) (Math.random() * this.board.getBoard().length - 1);
            int y = (int) (Math.random() * this.board.getBoard().length - 1);
            if (board.getBoard()[x][y].getUnit() == null) {
                this.currentCell = board.getBoard()[x][y];
                this.currentCell.setUnit(Unit);
                break;
            }
        }
    }

    /**
     * method generates all possibles moves.
     *
     * @return array, with all possibles moves.
     */

    private Cell[] getPossiblesMoves() {
        Cell[] moves = new Cell[4];
        int count = 0;
            moves[count++] = new Cell(currentCell.getAxisX(), currentCell.getAxisY() + 1);
            moves[count++] = new Cell(currentCell.getAxisX(), currentCell.getAxisY() - 1);
            moves[count++] = new Cell(currentCell.getAxisX() + 1, currentCell.getAxisY());
            moves[count++] = new Cell(currentCell.getAxisX() - 1, currentCell.getAxisY());
        return moves;
    }

    /**
     * run.
     */
    @Override
    public void run() {
        currentCell.lock();
        while (!Thread.currentThread().isInterrupted()) {
            List<Cell> cells = Arrays.asList(this.getPossiblesMoves());
            this.printBoard();
            Cell futureCell = null;
            boolean blockCell = false;
            try {
                while (!blockCell) {
                    futureCell = input.makeAStep("Enter new cell for your unit ", cells);
                    if (ValidateData.checkValidateMove(this.getBoard(), futureCell)) {
                        try {
                            blockCell = futureCell.tryLock(500, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e) {
                            blockCell = true;
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                }
            } finally {
                try {
                    board.getBarrier().await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                board.setOnTheBoard(futureCell, this, currentCell);
                currentCell.unlock();
                this.currentCell = futureCell;
            }
        }
    }
    /**
     * print board. The delay is made for the monsters to make a move.
     */
    private void printBoard() {
        if (this instanceof Player) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            board.createOrPrintBoard();
        }
    }
    /**
     * get current cell.
     *
     * @return
     */
    public Cell getCurrentCell() {
        return currentCell;
    }

    /**
     * get board.
     *
     * @return board.
     */
    public Board getBoard() {
        return board;
    }


}
