package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 *
 */
public class King extends Figure {
    public King(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption {

        Cell[] moves;

        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        int xMove = Math.abs(posX - destX);
        int yMove = Math.abs(posY - destY);

        if (xMove + yMove == 1 || xMove==yMove){
            moves = createPath(destenation);
        } else {
            throw new ImposibleMoveExeption("King does not go well");
        }

        return moves;
    }
}
