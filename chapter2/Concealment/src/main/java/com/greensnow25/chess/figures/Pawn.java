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


    public Pawn(Cell position, Board board) {
        super(position, board);

    }


    @Override
    public Cell[] way(Cell destination) throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException {
     // board.move(position,destination);

        Cell[] moves = new Cell[10];
        if (!position.getAxisX().equals(destination.getAxisX()) ||
                Integer.parseInt(destination.getAxisY()) - Integer.parseInt(position.getAxisY()) > 1) {
            throw new ImposibleMoveExeption("ход невозможен.");

        } else {
            int count = 0;

            for (int y = 0; y != board.getAxisY().length; y++) {
                for (int x = 0; x != board.getAxisX().length; x++) {

                    if (board.getAxisX()[x].equals(position.getAxisX()) && board.getAxisY()[y].equals(position.getAxisY())) {

                        for (int yMove = y; yMove != 0; yMove--) {

                            moves[count++] = new Cell(board.getAxisX()[x], board.getAxisY()[yMove]);
                            if (board.getAxisY()[yMove].equals(destination.getAxisY())) {
                                break;
                            }

                        }
                    }
                }
            }

        }

        return moves;
    }

}
