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
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException {

        Cell[] moves = new Cell[2];
        int count = 0;
        int moveHorizontal = 0;
        int moveDiagonal = 0;
        int moveVertikal = 0;

        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        if (Math.abs(posX - destX) == 1 && Math.abs(posY - destY) == 0) {
            moveHorizontal = 1;
        } else if (Math.abs(posX - destX) == 0 && Math.abs(posY - destY) == 1) {
            moveVertikal = 1;
        } else if (Math.abs(posX - destX) == 1 && Math.abs(posY - destY) == 1) {
            moveDiagonal = 1;
        }

        if (moveHorizontal == 1 || moveVertikal == 1 || moveDiagonal == 1) {
            moves[count++] = new Cell(destX, destY);
        } else {
            throw new ImposibleMoveExeption("King does not go well");
        }

        return moves;
    }
}
