package com.greensnow25.chess.figures;

import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;

/**
 * arstract class Figure.
 *
 * @author greensnow 25.
 * @version 3.
 * @since 08.02.17.
 */
public abstract class Figure {
    /**
     * figure position on the board.
     */
    final Cell position;

    /**
     * constructor of class.
     *
     * @param position figure position on board.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * method describes a possible path of movement of the figure.
     * on the chessboard, and checks whether the motion is possible.
     *
     * @param destenation position on board where need to move figure.
     * @return array of cells that figure should go to the designated path.
     * @throws ImposibleMoveExeption figure do not move that.
     */
    public abstract Cell[] way(Cell destenation) throws ImposibleMoveExeption;

    /**
     * method describes a possible path of movement of the figure.
     * on the chessboard, and checks whether the motion is possible.
     *
     * @param destenation position on board where need to move figure.
     * @return array of cells that figure should go to the designated path.
     * @throws ImposibleMoveExeption figure do not move that.
     */
    public Cell[] createPath(Cell destenation) throws ImposibleMoveExeption {
        int count = 0;
        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        // condition that selects the direction of movement of the figure

        int xMove = destX > posX ? 1 : destX < posX ? -1 : 0;
        int yMove = destY > posY ? 1 : destY < posY ? -1 : 0;

        int counterX = Math.abs(destX - posX);
        int counterY = Math.abs(destY - posY);

        // determine the length of the array, which will be written the way figures.

        int arrayLenght = counterX > counterY ? counterX : counterY;

        Cell[] moves = new Cell[arrayLenght + 1];
        for (int i = 0; i != arrayLenght + 1; i++) {
            moves[count++] = new Cell(posX, posY);
            posX += xMove;
            posY += yMove;
        }
        return moves;
    }

    /**
     * method show position.
     *
     * @return position.
     */
    public Cell getPosition() {
        return position;
    }


}
