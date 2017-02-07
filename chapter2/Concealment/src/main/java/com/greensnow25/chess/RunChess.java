package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;
import com.greensnow25.chess.figures.*;

/**
 *
 */
public class RunChess {

    public static void main(String[] args) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();
     Pawn pawn = new Pawn(new Cell(3,4));
       board.addFigure(pawn);
        board.fillingboard();
      Bishop bishop = new Bishop(new Cell (2,6));
       board.addFigure(bishop);
      bishop.way(new Cell(5,3));
        board.move(new Cell(2,6), new Cell(5,3));



    }
}
