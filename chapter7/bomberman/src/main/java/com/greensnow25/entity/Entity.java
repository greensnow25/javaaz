package com.greensnow25.entity;

import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;

/**
 * Public class Entity.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public abstract class Entity {
    /**
     * playing board.
     */
    private final Board board;
    private  Cell currentCell;

    /**
     * constructor.
     *
     * @param board board.
     */
    public Entity(Board board) {
        this.board = board;

    }

    /**
     * move object.
     * <p>
     * // * @param currentPosition current position.
     *
     * @return array of all possibles moves.
     */
    abstract Cell[] move();

    /**
     * method generate once entity.
     *
     * @param entity for game.
     */
    public void generateEntity(Entity entity) {
        while (true) {
            int x = (int) (Math.random() * this.board.getBoard().length-1);
            int y = (int) (Math.random() * this.board.getBoard().length-1);
            if (board.getBoard()[x][y].getEntity() == null) {
                this.currentCell = board.getBoard()[x][y];
                this.currentCell.setEntity(entity);
            }
        }
    }
    /**
     * The method checks whether it is worth it in the way of the barrier.
     *
     * @return result.
     */
    private boolean checkValidateMoves() {
        boolean res = false;
        try {
            if (board[possibleMoves.getAxisX()][possibleMoves.getAxisY()].getEntity() == null) {
                res = true;
            } else if (board[possibleMoves.getAxisX()][possibleMoves.getAxisY()].getEntity() instanceof Player) {
                res = true;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            //NON*?
        } finally {
            return res;
        }
    }

    /**
     * method check does the entity go beyond the field.
     *
     * @param possibleMoves position.
     * @return result.
     */
    private boolean checkOutTheBoard(Cell possibleMoves) {
        boolean res = true;
        if (possibleMoves.getAxisX() > this.size || possibleMoves.getAxisY() > this.size
                || possibleMoves.getAxisX() < 0 || possibleMoves.getAxisY() < 0) {
            res = false;
        }
        return res;
    }


    public Cell getCurrentCell() {
        return currentCell;
    }
}
