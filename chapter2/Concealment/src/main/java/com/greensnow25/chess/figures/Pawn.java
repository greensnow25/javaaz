package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 * public class Pawn.
 *
 * @author greensnow 25.
 * @version 1.
 * @since 30.01.17.
 */
public class Pawn extends Figure {

    public Pawn(Cell position) {
        super(position);

    }


    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption {
        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        Cell[] moves ;

        if (posX == destX || posY != destY) {
          moves = createPath(destenation);

        } else {
            throw new ImposibleMoveExeption("PAWN IMPOSIBLI MOVE");
        }

        return moves;
    }

}
