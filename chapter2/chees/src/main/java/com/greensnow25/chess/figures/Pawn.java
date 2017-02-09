package com.greensnow25.chess.figures;

import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;

/**
 * public class Pawn describes a possible path of movement of the figure.
 * on the chessboard, and checks whether the motion is possible.
 *
 * @author greensnow 25.
 * @version 3.
 * @since 08.02.17.
 */
public class Pawn extends Figure {
    /**
     * field describes the first movement of the figure.
     */
    private int firstMove = 2;


    /**
     * constructor of class.
     *
     * @param position figure position on board.
     * @param color    if int color = -1 then move pawn down up. else color =1 up down.
     */
    public Pawn(Cell position, int color) {
        super(position, color);

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

        if (posX == destX && posY != destY) {
            moves = createPath(destenation);
        } else {
            throw new ImposibleMoveExeption("PAWN IMPOSIBLI MOVE");
        }

        return moves;
    }

    @Override
    public Cell[] createPath(Cell destenation) throws ImposibleMoveExeption {
        Cell[] result = super.createPath(destenation);

        if (firstMove == 2 && result.length == 3) {
            firstMove--;
            return result;
        } else if (firstMove < 2 && result.length == 2) {
            firstMove = 0;
            return result;
        } else {
            throw new ImposibleMoveExeption("ONLI FIRST MOVE YOU MAY MOVED FIGURE ON TWO SELS");
        }

    }
}
