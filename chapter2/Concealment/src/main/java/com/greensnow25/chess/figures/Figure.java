package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;

/**
 * public abstact class.
 */
public abstract class Figure {

    final Cell position;
    private int color;

    public Figure(Cell position, int color) {
        this.position = position;
        this.color = color;
    }

    public Figure(Cell position) {
        this.position = position;
    }

    abstract public Cell[] way(Cell destenation) throws ImposibleMoveExeption, FigureNotFoundException, OccupiedWayException;


    public Cell[] createPath(Cell destenation) throws ImposibleMoveExeption {


        int count = 0;

        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();

        int xMove = destX > posX ? 1 : destX < posX ? -1 : 0;
        int yMove = destY > posY ? 1 : destY < posY ? -1 : 0;

        if (this.color == 1) {
            yMove = 1;
        } else if (this.color == -1){
            yMove = -1;
        }

        int counterX = Math.abs(destX - posX);
        int counterY = Math.abs(destY - posY);
        int arrayLenght = counterX > counterY ? counterX : counterY;

        Cell[] moves = new Cell[arrayLenght + 1];
        for (int i = 0; i != arrayLenght + 1; i++) {
            moves[count++] = new Cell(posX, posY);
            posX += xMove;
            posY += yMove;
        }

        return moves;
    }


    public Cell getPosition() {
        return position;
    }


}
