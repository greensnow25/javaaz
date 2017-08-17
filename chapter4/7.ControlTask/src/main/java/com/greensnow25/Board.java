package com.greensnow25;

import com.greensnow25.board.Cross;
import com.greensnow25.board.Figure;
import com.greensnow25.board.Naught;

/**
 * public class Board.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class Board {
    /**
     * field for the game.
     */
    private Figure[][] figures;

    /**
     * the default constructor, the size of the game field is 3.
     */
    public Board() {
        this.figures = new Figure[3][3];
    }

    /**
     * constructor indicate size of the field.
     *
     * @param size of the field.
     */
    public Board(int size) {
        this.figures = new Figure[size][size];
    }

    /**
     * add figure to the field.
     *
     * @param figure figure.
     * @return if figure add return true.
     */
    public boolean addFigure(Figure figure) {
        boolean result = false;
        if (figures[figure.getAxisX()][figure.getAxisY()] == null) {
            figures[figure.getAxisX()][figure.getAxisY()] = figure;
            result = true;
        }
        return result;
    }

    /**
     * print model.
     */
    public void showBoard() {
        for (int i = 0; i != figures.length; i++) {
            for (int j = 0; j != figures[i].length; j++) {
                if (figures[i][j] == null) {
                    System.out.print(" | ");
                } else if (figures[i][j] instanceof Cross) {
                    System.out.print(" X ");
                } else if (figures[i][j] instanceof Naught) {
                    System.out.print(" O ");
                }
            }
            System.out.println(System.getProperty("line.separator"));
        }
    }

    /**
     * Check if there are still moves.
     *
     * @return if no moves return true.
     */
    public boolean noMoves() {
        int count = 0;
        for (int i = 0; i != this.figures.length; i++) {
            for (int j = 0; j != this.figures[i].length; j++) {
                if (this.figures[i][j] == null) {
                    count++;
                }
            }
        }
        return count == 0 ? true : false;
    }

    /**
     * get figure[][].
     *
     * @return figures[][].
     */
    public Figure[][] getFigures() {
        return figures;
    }

}
