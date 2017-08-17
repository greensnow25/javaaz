package com.greensnow25.game;

import com.greensnow25.Board;
import com.greensnow25.board.Figure;

/**
 * public class Rule.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public abstract class Rule {
    /**
     * Check conditions for victory.
     *
     * @param board              field for the game.
     * @param figure             Figure with which to begin the test.
     * @param figureCountForWind condition for victory.
     * @return boolean.
     */
    abstract boolean check(Board board, Figure figure, int figureCountForWind);

    /**
     * We calculate figures of a certain type necessary for victor.
     *
     * @param board      model.
     * @param lastFigure Figure from which begins the calculation of figures.
     * @param directX    Direction of movement along the x axis.
     * @param directY    Direction of movement along the y axis
     * @param counting   counting figures.
     * @return sum of the figures satisfying conditions.
     */
    public int countingFigures(Board board, Figure lastFigure, int directX, int directY, int counting) {
        int count = 0;
        int axisX = lastFigure.getAxisX() + directX;
        int axisY = lastFigure.getAxisY() + directY;
        if (!outOfRange(axisX, axisY, board)) {
            if (board.getFigures()[axisX][axisY] == null
                    || !lastFigure.getClass().equals(board.getFigures()[axisX][axisY].getClass())) {
                return count;
            } else if (lastFigure.getClass().equals(board.getFigures()[axisX][axisY].getClass())) {
                count++;
                int res = this.countingFigures(board, board.getFigures()[axisX][axisY], directX, directY, count);
                count = ++res;
            }
        }
        return count;
    }

    /**
     * Check if we go beyond the borders of the field.
     *
     * @param axisX axis x.
     * @param axisY axis y.
     * @param board boadr.
     * @return if out of the model then return true.
     */
    private boolean outOfRange(int axisX, int axisY, Board board) {
        boolean result = false;
        if (axisX < 0 || axisY < 0 || axisX >= board.getFigures().length || axisY >= board.getFigures().length) {
            result = true;
        }
        return result;
    }
}
