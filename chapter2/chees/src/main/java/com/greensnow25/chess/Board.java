package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;
import com.greensnow25.chess.figures.Figure;

/**
 * public class Board draw the board and checks the validity of entered data.
 * if data true then figure move.
 *
 * @author greensnow 25.
 * @version 2.
 * @since 30.01.17.
 */
public class Board {
    /**
     * figure on the chess board.
     */
    private Figure figure;
    /**
     * figure position in array.
     */
    private int positionFigure = 0;
    /**
     * array of figures.
     */
    private Figure[] figures = new Figure[10];
    /**
     * chess board size.
     */
    private int size = 8;

    /**
     * method add figure on figures array.
     *
     * @param figure that add.
     * @return figure.
     */
    public Figure addFigure(Figure figure) {

        this.figures[positionFigure++] = figure;
        return figure;
    }

    /**
     * method move figure and conducts inspections.
     *
     * @param sourse   original position figures.
     * @param distanse the position where you want to move the figure.
     * @return is action possible.
     * @throws ImposibleMoveExeption   it is impossible to move the piece because of incorrect data.
     * @throws OccupiedWayException    in the way of the figures is another figure.
     * @throws FigureNotFoundException figure not found in sourse.
     */
    public boolean move(Cell sourse, Cell distanse) throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeption {
        figure = findFigure(sourse);
        boolean result = imposibleMove(distanse);

        try {
            if (figure == null) {
                throw new FigureNotFoundException("FIGURE NOT FOUND");
            } else if (result) {
                throw new OccupiedWayException("IMPOSEBLI MOVE. THE POSITION OCCUPIED ANOTHER FIGURE");
            }
        } catch (FigureNotFoundException | OccupiedWayException ex) {
            ex.printStackTrace();
        }

        // if conditions is true, move figure at destenation.

        figure.getPosition().setAxisX(distanse.getAxisX());
        figure.getPosition().setAxisY(distanse.getAxisY());
        return result;
    }

    /**
     * method find figure in sourse.
     *
     * @param sourse cell boards where the figure set.
     * @return return figure if it is found.
     */
    final Figure findFigure(Cell sourse) {
        Figure fig = null;
        for (int i = 0; i != positionFigure; i++) {
            if (figures[i].getPosition().equals(sourse) && figures[i] != null) {
                fig = figures[i];
            }
        }
        return fig;
    }

    /**
     * @param distanse the cell which should go figure.
     * @return if checs validate return false.
     * @throws OccupiedWayException    in the way of the figures is another figure.
     * @throws FigureNotFoundException throws exeption, if figure is not found.
     */
    public boolean imposibleMove(Cell distanse) throws OccupiedWayException, FigureNotFoundException, ImposibleMoveExeption {
        boolean result = false;
        Cell[] cellMoves;
        int imposibleMoveSize = distanse.getAxisX() > distanse.getAxisY() ?
                distanse.getAxisX() : distanse.getAxisY();
        cellMoves = figure.way(distanse);

        for (int i = 0; i != positionFigure; i++) {
            for (int j = 0; j != cellMoves.length; j++) {

                if (!figures[i].equals(figure) && cellMoves[j].equals(figures[i].getPosition())
                        && cellMoves[j] != null && figures[i] != null) {
                    result = true;
                    throw new OccupiedWayException("IMPOSEBLI MOVE. THE POSITION OCCUPIED ANOTHER FIGURE");
                } else if (imposibleMoveSize >= size) {
                    throw new ImposibleMoveExeption("going beyond the dimensions of the chessboard");
                } else if (figures[i].equals(figure) && !cellMoves[cellMoves.length - 1].equals(distanse)
                        && cellMoves[j] != null && figures[i] != null) {
                    throw new ImposibleMoveExeption("WRONG COLOR OF THE FIGURE");

                }
            }
        }
        return result;
    }

}
