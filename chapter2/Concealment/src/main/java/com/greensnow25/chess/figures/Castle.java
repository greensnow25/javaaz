package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;

/**
 *
 */
public class Castle extends Figure {

    public Castle(Cell position) {
        super(position);
    }

    @Override


    public Cell[] way(Cell destenation) throws ImposibleMoveExeption {

        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        Cell[] moves;

        if (posX == destX || posY == destY ){
            moves = createPath(destenation);
        } else {
            throw new ImposibleMoveExeption("CASTLE IMPOSIBLE MOVE");
        }

            return moves;
        }


}
