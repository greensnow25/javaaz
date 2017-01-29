package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 *
 */
public abstract class Figure {

    final Cell position;



    public Figure(Cell position) {
        this.position = position;
    }
    abstract public Cell[] way(Cell position) throws ImposibleMoveExeption;


}
