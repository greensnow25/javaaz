package com.greensnow25.game;

import com.greensnow25.Board;
import com.greensnow25.modules.Figure;

/**
 * public class RuleOne.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public abstract class RuleOne {

    abstract boolean check(Board board, Figure figure, int figureCountForWind);

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

    private boolean outOfRange(int axisX, int axisY, Board board) {
        boolean result = false;
        if (axisX < 0 || axisY < 0 || axisX >= board.getFigures().length || axisY >= board.getFigures().length) {
            result = true;
        }
        return result;
    }
}
