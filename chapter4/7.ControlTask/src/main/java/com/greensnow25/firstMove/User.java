package com.greensnow25.firstMove;

import com.greensnow25.Board;
import com.greensnow25.Input.Input;
import com.greensnow25.modules.Cross;
import com.greensnow25.modules.Figure;
import com.greensnow25.modules.Naught;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.05.2017.
 */
public class User extends Player {

    /**
     * constructor.
     */
    public User() {
    }

    /**
     * user make move.
     *
     * @param board        field fjr the game.
     * @param input        input system.
     * @param choiceFigure figure played by player.
     * @return
     */

    @Override
    public Figure makeMove(Board board, Input input, int choiceFigure) {
        Figure figure = null;
        boolean correctAdd = false;
        int axisX = input.ask("enter axis X: ");
        int axisY = input.ask("enter axis Y: ");
        if (choiceFigure == 1) {
            figure = new Cross(axisX, axisY);
            correctAdd = board.addFigure(figure);
        } else if (choiceFigure == 2) {
            figure = new Naught(axisX, axisY);
            correctAdd = board.addFigure(figure);

        }
        if (!correctAdd) {
            System.out.println("Sorry, but the current field is already taken. Try again.");
            this.makeMove(board, input, choiceFigure);
        }

        return figure;
    }
}
