package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 * public class Board
 * descried chess board.
 *
 * @author greensnow 25.
 * @version 1.
 * @since 30.01.17.
 */
public class Board {
    /**
     * of array we take coorinates from axisY.
     */
    private String[] axisY = new String[]{"8", "7", "6", "5", "4", "3", "2", "1"};
    /**
     * of array we take coorinates from axisX.
     */
    private String[] axisX = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
    /**
     * array of figures.
     */
    Figure[] figures = new Figure[10];
    /**
     * method filing the board cells.
     * @return array of Cells.
     */
    public Cell[][] fillingboard() {
        Cell[][] result = new Cell[axisX.length][axisY.length];
        for (int y = 0; y != axisY.length; y++) {
            for (int x = 0; x != axisX.length; x++) {
                result[x][y] = new Cell(axisX[x], axisY[y]);

                System.out.print(result[x][y].getAxisX() + result[x][y].getAxisY() + " ");
            }
            System.out.println();
        }
        return result;
    }

    /**
     * method move figure.
     * @param sourse original position figures.
     * @param distanse the position where you want to move the piece.
     * @return is action possible.
     * @throws ImposibleMoveExeption
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
     public boolean move(Cell sourse, Cell distanse) throws ImposibleMoveExeption, OccupiedWayException,
            FigureNotFoundException {
         return true;
     }
    public static void main(String[] args) {
        Board board = new Board();
        board.fillingboard();

    }
}
