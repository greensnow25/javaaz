package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 *
 */
public abstract class Figure {

   final Cell position;

    protected Board board;

    public Figure(Cell position, Board board) {
        this.position = position;
        this.board = board;
    }

    abstract public Cell[] way(Cell position) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException;


}
