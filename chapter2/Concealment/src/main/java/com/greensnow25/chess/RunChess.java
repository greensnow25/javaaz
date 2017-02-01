package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;
import com.greensnow25.chess.figures.Castle;
import com.greensnow25.chess.figures.Figure;
import com.greensnow25.chess.figures.Pawn;

/**
 *
 */
public class RunChess {

    public static void main(String[] args) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException {
        Board board = new Board();

       Pawn pawn = new Pawn(new Cell("e","2"),board);


        pawn.way(new Cell ("e","3"));

    }
}
