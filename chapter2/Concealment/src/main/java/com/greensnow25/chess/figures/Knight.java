package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 *
 */
public class Knight extends Figure {
    public Knight(Cell position) {
        super(position);
    }

    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException {
        Cell[] move = new Cell[2];
        int count = 0;
        int loingHorse = 0;
        int standingHorse = 0;

        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();


        if (Math.abs(posX - destX) == 1 &&
                Math.abs(posY - destY) == 2) {
            standingHorse = 1;
        } else if (Math.abs(posX - destX) == 2 &&
                Math.abs(posY - destY) == 1) {
            loingHorse = 1;
        }

        if (standingHorse == 1 || loingHorse == 1) {
            move[count++] = new Cell(destX, destY);
        } else {
            throw new ImposibleMoveExeption("the horse does not go well");
        }

        return move;
    }
}
