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
    int firstMove = 2;
   // final int color;

    public Pawn(Cell position, int color) {
        super(position,color);
      //  this.color = color;
    }

    // if int color = 0 then move pawn down up. else color =1 down up.
    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption {
        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();



  //      int directionMove = color > 1 ? 1 : -1;

        int rangeMove = Math.abs(posY - destY);
        Cell[] moves;

        if (posX == destX && posY != destY && firstMove==2 ) {
            moves = createPath(destenation);
            firstMove--;
        }else if(posX == destX && posY != destY && firstMove!=2) {
            moves = createPath(destenation);
        } else {
            throw new ImposibleMoveExeption("PAWN IMPOSIBLI MOVE");
        }

        return moves;
    }

}
