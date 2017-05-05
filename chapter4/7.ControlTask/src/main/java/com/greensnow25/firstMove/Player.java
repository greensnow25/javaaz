package com.greensnow25.firstMove;

import com.greensnow25.Board;
import com.greensnow25.Input.Input;
import com.greensnow25.genrgateField.GenerateCompMove;
import com.greensnow25.modules.Figure;

/**
 * public class FirstMove.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public abstract class Player {
    /**
     * method checks who starts the game first.
     *
     * @param choiceMove The number depends on who will start the game first.
     * @return player.
     */
    public Player moveFirst(int choiceMove) {
        if (choiceMove == 1) {
            return new User();
        } else {
            return new Computer(new GenerateCompMove());
        }
    }

    /**
     * move figure.
     *
     * @param board        field fjr the game.
     * @param input        input system.
     * @param choiceFigure figure played by player.
     * @return figure.
     */
    public abstract Figure makeMove(Board board, Input input, int choiceFigure);


}
