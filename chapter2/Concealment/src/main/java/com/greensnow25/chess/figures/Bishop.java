package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 *
 */
public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption {
        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();
        Cell[] moves;

        if (Math.abs(posX - destX) == Math.abs(posY - destY)) {
            moves = createPath(destenation);
        } else {
            throw new ImposibleMoveExeption("BISHOP IMPOSIBLE MOVE");
        }


        return moves;
    }
}
