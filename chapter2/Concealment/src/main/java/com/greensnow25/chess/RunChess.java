package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.figures.Castle;
import com.greensnow25.chess.figures.Figure;
import com.greensnow25.chess.figures.Pawn;

/**
 *
 */
public class RunChess {

    public static void main(String[] args) throws ImposibleMoveExeption {
        Board board = new Board();
     //   board.addFigure(new Pawn(new Cell("e","2")));
        Pawn pawn = new Pawn(new Cell("e","2"));
        Castle castle = new Castle(new Cell("e", "3"));
        board.addFigure(pawn);
        board.addFigure(castle);
        pawn.way(new Cell ("e","3"),board);
    }
}
