package com.greensnow25.chess.figures;

import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;

/**
 * public class Bishop describes a possible path of movement of the figure.
 * on the chessboard, and checks whether the motion is possible.
 *
 * @author greensnow 25.
 * @version 3.
 * @since 08.02.17.
 */

public class Bishop extends Figure {
    /**
     * constructor of class.
     *
     * @param position figure position on board.
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * method describes a possible path of movement of the figure.
     * on the chessboard, and checks whether the motion is possible.
     *
     * @param destenation position on board where need to move figure.
     * @return array of cells that figure should go to the designated path.
     * @throws ImposibleMoveExeption figure do not move that.
     */
    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveExeption {
        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();
        Cell[] moves;

        // the condition of the correctness of the movement of the figure

        if (Math.abs(posX - destX) == Math.abs(posY - destY)) {
            moves = createPath(destenation);
        } else {
            throw new ImposibleMoveExeption("BISHOP IMPOSIBLE MOVE");
        }


        return moves;
    }
}
