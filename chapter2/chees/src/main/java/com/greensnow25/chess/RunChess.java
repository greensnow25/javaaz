package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;
import com.greensnow25.chess.figures.Castle;
import com.greensnow25.chess.figures.Knight;
import com.greensnow25.chess.figures.Pawn;


/**
 *
 */
public class RunChess {
    /**
     * wdfd.
     *
     * @param args ew.
     * @throws ImposibleMoveExeption      wd.
     * @throws OccupiedWayException       wd.
     * @throws FigureNotFoundException    wd.
     * @throws CloneNotSupportedException wd.
     */
    public static void main(String[] args) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException, CloneNotSupportedException {
        Board board = new Board();
Castle castle = new Castle(new Cell (7,5));
        board.addFigure(castle);
        board.move(castle.getPosition(), new Cell(9,5));


//        Pawn pawn = new Pawn(new Cell(2, 5), 1);
//        board.addFigure(pawn);
//        board.move(pawn.getPosition(), new Cell(2, 6));
      //  board.move(pawn.getPosition(), new Cell(2, 2));
        //     board.move(new Cell(2, 5), new Cell(2, 6));
        //      board.move(new Cell(2,3), new Cell(2,2));
        //       Knight bishop = new Knight(new Cell(2, 4));
        //      board.addFigure(bishop);
        //    bishop.way(new Cell(3,2));
        // bishop.way(new Cell(2, 7));
        // board.move(new Cell(2, 4), new Cell(2, 6));
        //  board.move(new Cell(2,6), new Cell(2,7));


    }
}
