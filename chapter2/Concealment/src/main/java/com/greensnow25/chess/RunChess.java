package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;
import com.greensnow25.chess.figures.*;

/**
 *
 */
public class RunChess {

    public static void main(String[] args) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException, CloneNotSupportedException {
        Board board = new Board();
     Pawn pawn = new Pawn(new Cell(2,5), 1);
       board.addFigure(pawn);
        board.fillingboard();
        board.move(new Cell(2,5), new Cell(2,6));
  //      board.move(new Cell(2,3), new Cell(2,2));
      Castle bishop = new Castle(new Cell (2,4));
       board.addFigure(bishop);
      bishop.way(new Cell(2,6));
        bishop.way(new Cell(2,7));
        board.move(new Cell(2,4), new Cell(2,6));
      //  board.move(new Cell(2,6), new Cell(2,7));



    }
}
