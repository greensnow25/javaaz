package com.greensnow25.entity;

import com.greensnow25.input.Input;
import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;
import com.greensnow25.validateData.ValidateData;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Public class Entity.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public abstract class Entity implements Runnable {
    /**
     * playing board.
     */
    private final Board board;
    private Cell currentCell;
    private final Input input;

    /**
     * constructor.
     *
     * @param board board.
     * @param input
     */
    public Entity(Board board, Input input) {
        this.board = board;
        this.input = input;
        this.generateEntity(this);

    }


    /**
     * method generate once entity.
     *
     * @param entity for game.
     */
    public void generateEntity(Entity entity) {
        while (true) {
            int x = (int) (Math.random() * this.board.getBoard().length - 1);
            int y = (int) (Math.random() * this.board.getBoard().length - 1);
            if (board.getBoard()[x][y].getEntity() == null) {
                this.currentCell = board.getBoard()[x][y];
                this.currentCell.setEntity(entity);
                break;
            }
        }
    }

    /**
     * method generates all possibles moves.
     *
     * @return array, with all possibles moves.
     */

    public Cell[] getPossiblesMoves() {
        Cell[] moves = new Cell[4];
        int count = 0;
        try {
            moves[count++] = board.getBoard()[currentCell.getAxisX()][currentCell.getAxisY() + 1];
            moves[count++] = board.getBoard()[currentCell.getAxisX()][currentCell.getAxisY() - 1];
            moves[count++] = board.getBoard()[currentCell.getAxisX() + 1][currentCell.getAxisY()];
            moves[count++] = board.getBoard()[currentCell.getAxisX() - 1][currentCell.getAxisY()];
        } catch (ArrayIndexOutOfBoundsException ex) {

        }
        return moves;
    }

    @Override
    public void run() {
        currentCell.lock();
        while (!Thread.currentThread().isInterrupted()) {
            List<Cell> cells = Arrays.asList(this.getPossiblesMoves());
            int i;
            waitAndPrint();
            Cell futureCell = null;
            boolean blockCell = false;
            try {
                while (!blockCell) {
                    futureCell = input.inputCell("Enter new cell for your unit: ", cells);
                    if (ValidateData.checkValidateMove(this.getBoard(), futureCell)) {
                        try {
                            blockCell = futureCell.tryLock(500, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    } else {
                       // cells.remove(futureCell);
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

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

    public Board getBoard() {
        return board;
    }

    public void waitAndPrint(){
        if(this instanceof Player){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            board.createAndPrintBoard();
        }
    }
}
