package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;
import com.greensnow25.chess.figures.Figure;
import com.greensnow25.chess.figures.Pawn;

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
    private int[] axisY = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    /**
     * of array we take coorinates from axisX.
     */
    private int[] axisX = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    /**
     * array of figures.
     */
    int positionFigure = 0;

    Figure[] figures = new Figure[10];

    Cell[][] result = new Cell[axisX.length][axisY.length];

    /**
     * method filing the board cells.
     *
     * @return array of Cells.
     */
    public Figure addFigure(Figure figure) {

        this.figures[positionFigure++] = figure;
        return figure;
    }

    public Cell[][] fillingboard() {

        for (int y = 0; y != axisY.length; y++) {
            for (int x = 0; x != axisX.length; x++) {
                result[x][y] = new Cell(axisX[x], axisY[y]);
                System.out.print(result[x][y].getAxisX() + "" + result[x][y].getAxisY() + " ");
            }
            System.out.println();
        }
        return result;
    }

    /**
     * method move figure.
     *
     * @param sourse   original position figures.
     * @param distanse the position where you want to move the piece.
     * @return is action possible.
     * @throws ImposibleMoveExeption
     * @throws OccupiedWayException
     * @throws FigureNotFoundException
     */
    public boolean move(Cell sourse, Cell distanse) throws ImposibleMoveExeption, OccupiedWayException,
            FigureNotFoundException {
        Figure figure = null;
        for (int i = 0; i != positionFigure; i++) {
            if (figures[i].getPosition().equals(sourse) && figures[i] != null) {
                figure = figures[i];
            }
        }
        if (figure == null) {
            throw new FigureNotFoundException("FIGURE NOT FOUND");
        }

        Cell[] cellMoves = figure.way(distanse);
        for (int i = 0; i != positionFigure; i++) {
            for (int j = 0; j !=cellMoves.length; j++) {
      //          if (!figures[i].equals(figure) && cellMoves[j] != null && figures[i] !=null) {
      //              System.out.println("efwfwefregreg");
      //              break;
        //        }


            }
        }


        return true;
    }


    public Figure[] getFigures() {
        return figures;
    }

    public Cell[][] getResult() {
        return result;
    }

    public int[] getAxisX() {
        return axisX;
    }

    public int[] getAxisY() {
        return axisY;
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }
}
