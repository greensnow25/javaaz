package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 *
 */
public class Queen extends Figure {
    public Queen(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption {
        Cell[] moves ;

        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        int xMove = Math.abs(posX - destX);
        int yMove = Math.abs(posY - destY);

        if (xMove == yMove || posX == destX || posY == destY){
            moves = createPath(destenation);
        }
        else {
            throw new ImposibleMoveExeption("the queen does not go well");
        }
        return moves;
    }
}



