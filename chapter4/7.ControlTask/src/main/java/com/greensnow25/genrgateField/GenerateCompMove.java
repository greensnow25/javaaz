package com.greensnow25.genrgateField;

import com.greensnow25.Board;
import com.greensnow25.modules.Cross;
import com.greensnow25.modules.Figure;

/**
 * public class GenerateCompMove.
 *
 * @author greensnow25.
 * @version 1.
 * @since 29.04.2017.
 */
public class GenerateCompMove {
    public boolean generate(Board board, Figure figure) {
        boolean canAdd = false;

        do {

            int length = board.getFigures().length;
            int axisX = (int) (Math.random() * length);
            int axisY = (int) (Math.random() * length);
            if (board.getFigures()[axisX][axisY] == null) {
                figure.setAxisX(axisX);
                figure.setAxisY(axisY);
                board.addFigure(figure);
                canAdd = true;
            }
        } while (!canAdd);
        return canAdd;
    }
}
