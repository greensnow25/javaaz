package com.greensnow25.chess.figures;

import com.greensnow25.chess.Board;
import com.greensnow25.chess.Cell;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;

/**
 * public class Pawn.
 *
 * @author greensnow 25.
 * @version 1.
 * @since 30.01.17.
 */
public class Pawn extends Figure {


    public Pawn(Cell position) {
        super(position);
    }


    @Override
    public Cell[] way(Cell destination) throws ImposibleMoveExeption {
        Board board = new Board();
        Cell[][] res = board.fillingboard();
        Figure fi = board.addFigure(new Pawn(new Cell("e", "2")));

        Cell[] result = new Cell[10];
        int count = 0;


        for (int x = 0; x != board.getResult().length; x++) {                   //просматриваем ось Х на доске
            for (int y = 0; y != board.getResult().length; y++) {               //просматриваем ось У н
                for (int i = 0; i != board.getFigures().length; i++) {          //просматриваем фигуры , которые мы добавили
                    if (board.getFigures()[i] != null && res[x][y].equals(fi.getPosition())) {   //уславие для поиска месторосположения фигуры пешка
                        for (int yStart = y ; yStart != res.length-1 - Integer.parseInt(destination.getAxisY()); yStart--) { //просматриваем ось У, и связываем с желаемой позициейю
                            if (Integer.parseInt(destination.getAxisY()) -                                  //условие по которому пешка мошет двигатся только на 1 клетку вперед.
                                    Integer.parseInt(board.getFigures()[i].getPosition().getAxisY()) == 1) {
                                result[count++] = res[x][yStart];                                            //записываем, через какие клетки предстоит пройти
                                System.out.print(res[x][y].getAxisX() + res[x][yStart].getAxisY() + "  ");
                            } else {
                                throw new ImposibleMoveExeption("Ход невозможен");
                            }
                        }
                        break;


                    }

                }
            }
        }

        return result;


    }

    public static void main(String[] args) throws ImposibleMoveExeption {
        Board board = new Board();
        Figure figure = new Pawn(new Cell("e", "2"));
        board.addFigure(figure);
        figure.way(new Cell("e", "3"));
    }

    @Override
    public Cell getPosition() {
        return super.getPosition();
    }
}
