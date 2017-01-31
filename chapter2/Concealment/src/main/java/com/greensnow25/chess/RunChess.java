package com.greensnow25.chess;

import com.greensnow25.chess.figures.Figure;
import com.greensnow25.chess.figures.Pawn;

/**
 *
 */
public class RunChess {

    public static void main(String[] args) {
        Board board = new Board();

        board.addFigure(new Pawn(new Cell("e","2")));

    }
}
