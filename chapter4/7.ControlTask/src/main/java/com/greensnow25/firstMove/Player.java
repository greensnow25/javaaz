package com.greensnow25.firstMove;

import com.greensnow25.Board;
import com.greensnow25.Input.Input;
import com.greensnow25.genrgateField.GenerateCompMove;
import com.greensnow25.modules.Cross;
import com.greensnow25.modules.Figure;
import com.greensnow25.modules.Naught;

/**
 * public class FirstMove.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public abstract class Player {

    public Player moveFirst(int choiceMove) {
        User user = new User();
        if (choiceMove == 1) {

            return user;
        } else
            return new Computer(new GenerateCompMove());
    }


    public abstract Figure makeMove(Board board, Input input, int choiceFigure);


}
