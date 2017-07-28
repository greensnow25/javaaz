package com.greensnow25.entity;

import com.greensnow25.input.Input;
import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;
import com.greensnow25.validateData.ValidateData;

import java.util.Arrays;
import java.util.List;
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
    }

//    /**
//     * move object.
//     * <p>
//     * // * @param currentPosition current position.
//     *
//     * @return array of all possibles moves.
//     */
//    abstract Cell[] move();

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
        moves[count++] = new Cell(currentCell.getAxisX(), currentCell.getAxisY() + 1);
        moves[count++] = new Cell(currentCell.getAxisX(), currentCell.getAxisY() - 1);
        moves[count++] = new Cell(currentCell.getAxisX() + 1, currentCell.getAxisY());
        moves[count++] = new Cell(currentCell.getAxisX() - 1, currentCell.getAxisY());

        return moves;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            List<Cell> cells = Arrays.asList(this.getPossiblesMoves());
            int i;
            boolean blockCell = false;
            while (!blockCell) {
                Cell currentCell = input.inputCell("Enter new cell for your unit: ", cells);
                if (ValidateData.checkValidateMove(this.getBoard(), currentCell)) {
                    try {
                        blockCell = currentCell.tryLock(500, TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    } finally {
                        this.currentCell = currentCell;
                        currentCell.unlock();
                    }
                } else {
                    cells.remove(currentCell);
                }


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
}
