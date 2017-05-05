package com.greensnow25.game;

import com.greensnow25.Board;
import com.greensnow25.modules.Figure;

/**
 * public class Rules.
 *
 * @author greensnow25.
 * @version 1.
 * @since 03.05.2017.
 */
public class RulesDiagonal extends Rule {
    /**
     * Check conditions for victory.
     *
     * @param board              field for the game.
     * @param figure             Figure with which to begin the test.
     * @param figureCountForWind condition for victory.
     * @return
     */
    @Override
    public boolean check(Board board, Figure lastFigure, int figureCountForWin) {

        boolean result = false;
        // last numbers ... -1 Direction of movement along the x axis.
        //                   1 Direction of movement along the y axis.
        //                   0 counting figures in this direction.
        int firstQuarter = super.countingFigures(board, lastFigure, -1, 1, 0);
        int secondQuarter = super.countingFigures(board, lastFigure, -1, -1, 0);
        int thirdOuarter = super.countingFigures(board, lastFigure, 1, -1, 0);
        int fourthQuarter = super.countingFigures(board, lastFigure, 1, 1, 0);

        if (firstQuarter + thirdOuarter + 1 == figureCountForWin
                || secondQuarter + fourthQuarter + 1 == figureCountForWin) {
            result = true;
        }

        return result;
    }


}
