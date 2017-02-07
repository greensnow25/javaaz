package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 *public abstact class.
 */
public abstract class Figure {

    final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract public Cell[] way(Cell destenation) throws ImposibleMoveExeption, FigureNotFoundException, OccupiedWayException;


    public Cell[] createPath(Cell destenation) throws ImposibleMoveExeption {
        Cell[] moves = new Cell[10];
        int count = 0;

        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        int xMove = 0;
        int yMove = 0;
        int nums = 0;

        if (posX > destX && posY > destY) {
            xMove = -1;
            yMove = -1;
        } else if (posX == destX && posY > destY) {
            xMove = 0;
            yMove = -1;
        } else if (posX < destX && posY > destY) {
            xMove = 1;
            yMove = -1;
        } else if (posX < destX && posY == destY) {
            xMove = 1;
            yMove = 0;
        } else if (posX < destX && posY < destY) {
            xMove = 1;
            yMove = 1;
        } else if (posX == destX && posY < destY) {
            xMove = 0;
            yMove = 1;
        } else if (posX > destX && posY < destY) {
            xMove = -1;
            yMove = 1;
        } else if (posX > destX && posY == destY) {
            xMove = -1;
            yMove = 0;
        }

        int counterX = Math.abs(destX - posX);
        int counterY = Math.abs(destY - posY);

        if (counterX > counterY) {
            nums = counterX;
        } else {
            nums = counterY;
        }

        for (int i = 0; i != nums + 1; i++) {
            moves[count++] = new Cell(posX, posY);
            posX += xMove;
            posY += yMove;
        }

        Cell[] cells = new Cell[count];

        System.arraycopy(moves, 0, cells, 0, count);

        if (!moves[count - 1].equals(new Cell(destX, destY))) {
            throw new ImposibleMoveExeption("IMPOSIBLE MOVE");
        }
        return cells;
    }


    public Cell getPosition() {
        return position;
    }


}
