package com.greensnow25.firstMove;

import com.greensnow25.Board;
import com.greensnow25.Input.Input;
import com.greensnow25.genrgateField.GenerateCompMove;
import com.greensnow25.modules.Cross;
import com.greensnow25.modules.Figure;
import com.greensnow25.modules.Naught;

/**
 * public class Computer.
 *
 * @author greensnow25.
 * @version 1.
 * @since 04.05.2017.
 */
public class Computer extends Player {

    GenerateCompMove generate;

    public Computer(GenerateCompMove generate) {
        this.generate = generate;
    }

    @Override
    public Figure makeMove(Board board, Input input, int choiceFigure) {
       Figure figure = null;
        if (choiceFigure == 2) {
            figure = new Cross();
            generate.generate(board, figure);
        } else if (choiceFigure == 1) {
            figure = new Naught();
            generate.generate(board,figure);
        }
        return figure;
    }
}
