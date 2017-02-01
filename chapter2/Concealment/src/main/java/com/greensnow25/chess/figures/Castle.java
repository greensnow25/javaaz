package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;

/**
 *
 */
public class Castle extends Figure {

    public Castle(Cell position, Board board) {
        super(position, board);
    }

    @Override
    public Cell[] way(Cell position) throws ImposibleMoveExeption {
    Cell[][] result = board.fillingboard();
    Cell[] movearray = new Cell[10];
        int count =0;
        for (int fig =0; fig != board.getFigures().length; fig++) {
            if (board.getFigures()[fig] instanceof Castle && board.getFigures()[fig] ==null) {

            }
        }
        return new Cell[0];
    }
}
