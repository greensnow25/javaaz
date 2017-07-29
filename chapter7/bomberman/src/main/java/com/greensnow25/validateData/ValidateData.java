package com.greensnow25.validateData;

import com.greensnow25.entity.Player;
import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;

/**
 * Public class validateData.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.07.2017.
 */
public class ValidateData {
    /**
     * The method checks whether it is worth it in the way of the barrier.
     *
     * @return result.
     */
    public static boolean checkValidateMove(Board board, Cell potentialMove) {
        boolean res = true;
        try {
            if (board.getBoard()[potentialMove.getAxisX()][potentialMove.getAxisY()].getEntity() != null) {
                res = false;
            } else if (potentialMove.getAxisX() >= board.getBoard().length || potentialMove.getAxisY() >= board.getBoard().length
                    || potentialMove.getAxisX() < 0 || potentialMove.getAxisY() < 0) {
                res = false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            res = false;
        } finally {
            return res;
        }
    }

}
