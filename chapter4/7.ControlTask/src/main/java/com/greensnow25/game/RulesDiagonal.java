package com.greensnow25.game;

import com.greensnow25.Board;
import com.greensnow25.modules.Cross;
import com.greensnow25.modules.Figure;
import com.greensnow25.modules.Naught;

/**
 * public class Rules.
 *
 * @author greensnow25.
 * @version 1.
 * @since 03.05.2017.
 */
public class RulesDiagonal extends RuleOne {
    @Override
    public boolean check(Board board, Figure lastFigure, int figureCountForWin) {

        boolean result = false;

        int firstQuarter = super.countingFigures(board, lastFigure, -1, 1, 0);
        int secondQuarter = super.countingFigures(board, lastFigure, -1, -1, 0);
        int thirdOuarter = super.countingFigures(board, lastFigure, 1, -1, 0);
        int fourthQuarter = super.countingFigures(board, lastFigure, 1, 1, 0);

        if (firstQuarter + thirdOuarter + 1 == figureCountForWin ||
                secondQuarter + fourthQuarter + 1 == figureCountForWin) {
            result = true;
        }

        return result;
    }


}
