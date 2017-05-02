package com.greensnow25;

import com.greensnow25.modules.Cross;
import com.greensnow25.modules.Figure;
import com.greensnow25.modules.Naught;

/**
 * public class Board.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class Board {

    public Figure[][] figures;

    public Board() {
        this.figures = new Figure[3][3];
    }

    public Board(int size) {
        this.figures = new Figure[size][size];
    }

    public boolean addFigure(Figure figure) {
        boolean result = false;
        if (figures[figure.getAxisX()][figure.getAxisY()] == null) {
            figures[figure.getAxisX()][figure.getAxisY()] = figure;
            result = true;
        } else {
            System.out.println("Sorry, but the current field is already taken");
        }
        return result;
    }

    public void showBoard() {
        for (int i = 0; i != figures.length; i++) {
            for (int j = 0; j != figures[i].length; j++) {
                if (figures[i][j] == null) {
                    System.out.println("  ");
                } else if (figures[i][j] instanceof Cross) {
                    System.out.println(" X ");
                } else if (figures[i][j] instanceof Naught) {
                    System.out.println(" O ");
                }
            }
            System.out.println(System.getProperty("line.separator"));
        }
    }
}
