package com.greensnow25.chess;

import com.greensnow25.chess.exeptions.FigureNotFoundException;
import com.greensnow25.chess.exeptions.ImposibleMoveExeption;
import com.greensnow25.chess.exeptions.OccupiedWayException;
import com.greensnow25.chess.figures.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Class BoardTest testing all possible scenarios of movement of all figures.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.02.17.
 */
public class BoardTest {

    /**
     * field board creating the bord.
     */
    private Board board;

    /**
     * pawn move down up.
     */
    private Pawn pawnDownUp;

    /**
     * pawn move up down.
     */
    private Pawn pawnUpDown;
    /**
     * field castle.
     */
    private Castle castle;
    /**
     * field knight.
     */
    private Knight knight;
    /**
     * field bishop.
     */
    private Bishop bishop;
    /**
     * field king.
     */
    private King king;
    /**
     * field queen.
     */
    private Queen queen;

    /**
     * field ByteArrayOutputStream.
     */
    private ByteArrayOutputStream out;

    /**
     * run method before test.
     */
    @Before
    public void beforeTest() {
        this.board = new Board();
        this.pawnDownUp = new Pawn(new Cell(1, 5), -1);
        this.pawnUpDown = new Pawn(new Cell(1, 1), 1);
        this.castle = new Castle(new Cell(7, 5));
        this.knight = new Knight(new Cell(6, 5));
        this.bishop = new Bishop(new Cell(5, 5));
        this.king = new King(new Cell(4, 5));
        this.queen = new Queen(new Cell(3, 5));
        this.out = new ByteArrayOutputStream();

    }

    /**
     * method add figure to figures array.
     */
    @Test
    public void whenFddFigureToFigureArrayThenFindThem() {
        board.addFigure(castle);
        Figure figure = board.findFigure(castle.getPosition());
        assertThat(castle, is(figure));

    }

    /**
     * board fills cells for clarity.
     */
    @Test
    public void wheFillingboardThenOutToConsole() {
        String sep = System.getProperty("line.separator");
        System.setOut(new PrintStream(out));
        board.fillingboard();
        String result = "00 10 20 30 40 50 60 70 " + sep
                + "01 11 21 31 41 51 61 71 " + sep
                + "02 12 22 32 42 52 62 72 " + sep
                + "03 13 23 33 43 53 63 73 " + sep
                + "04 14 24 34 44 54 64 74 " + sep
                + "05 15 25 35 45 55 65 75 " + sep
                + "06 16 26 36 46 56 66 76 " + sep
                + "07 17 27 37 47 57 67 77 " + sep;
        assertThat(out.toString(), is(result));
    }

    //PAWN TESTING.
    //MOVE DOWN.

    /**
     * method moves the pawn first on two cells and then another one down.
     * 2+1.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test
    public void whenMovePawnUpDownFirstTwoSecondOneThenSheisMovedDownUp() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(pawnUpDown);
        board.move(pawnUpDown.getPosition(), new Cell(1, 3));
        board.move(pawnUpDown.getPosition(), new Cell(1, 4));

        assertThat(pawnUpDown.getPosition(), is(new Cell(1, 4)));

    }

    /**
     * method moves the pawn first on two cells and then another two down.
     * 2+2
     *
     * @throws ImposibleMoveExeption   Entrance is not possible, a pawn two cells .
     *                                 forward can move only the first move.
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMovePawnUpDownFirstTwoSecondTwoThenThrowExeption() throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException {
        board.addFigure(pawnUpDown);
        board.move(pawnUpDown.getPosition(), new Cell(1, 3));
        pawnUpDown.way(new Cell(1, 5));

    }

    /**
     * method move pawn in wrond direction.
     *
     * @throws ImposibleMoveExeption wrond direction.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMovePawnUpDownInWrongDirectThenThrowExeption() throws ImposibleMoveExeption {
        board.addFigure(pawnUpDown);
        pawnDownUp.way(new Cell(1, 0));
    }

    /**
     * method checks if on the way the figure is another figure.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenPawnMveThenStopMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(pawnDownUp);
        board.addFigure(castle);
        board.move(castle.getPosition(), new Cell(1, 5));
        board.move(castle.getPosition(), new Cell(1, 2));
        board.move(knight.getPosition(), new Cell(1, 2));
    }

    //MOVED  PAWN UP.

    /**
     * method moved the pawn first on two cells and then another one up.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    //move up 2 +1.
    @Test
    public void whenMovePawnDownUpFirstTwoSecondOneThenSheisMovedDownUp() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(pawnDownUp);
        board.move(pawnDownUp.getPosition(), new Cell(1, 3));
        board.move(pawnDownUp.getPosition(), new Cell(1, 2));

        assertThat(pawnDownUp.getPosition(), is(new Cell(1, 2)));

    }

    /**
     * method moves the pawn first on two cells and then another two up.
     * 2+1
     *
     * @throws ImposibleMoveExeption   Entrance is not possible, a pawn two cells .
     *                                 forward can move only the first move.
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    //moved pawn 2+1.
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMovePawnDownUpFirstTwoSecondTwoThenThrowExeption() throws ImposibleMoveExeption, OccupiedWayException, FigureNotFoundException {
        board.addFigure(pawnDownUp);
        board.move(pawnDownUp.getPosition(), new Cell(1, 3));
        pawnDownUp.way(new Cell(1, 1));

    }

    /**
     * method move pawn in wrond direction.
     *
     * @throws ImposibleMoveExeption wrond direction.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMovePawnDownUpInWrongDirectThenThrowExeption() throws ImposibleMoveExeption {
        board.addFigure(pawnDownUp);
        pawnDownUp.way(new Cell(1, 6));


    }

    /**
     * method checks if on the way the figure is another figure.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenPawn1MveThenStopMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(pawnDownUp);
        board.addFigure(castle);
        board.move(castle.getPosition(), new Cell(1, 5));
        board.move(castle.getPosition(), new Cell(1, 4));
        board.move(knight.getPosition(), new Cell(1, 4));
    }

//MOVE THE CASTLE.

    /**
     * Move the pieces either horizontally or vertically.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test
    public void whenCastleMveThenSheMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(castle); //75
        board.move(castle.getPosition(), new Cell(7, 2));
        board.move(castle.getPosition(), new Cell(2, 2));
        board.move(castle.getPosition(), new Cell(2, 6));
        board.move(castle.getPosition(), new Cell(5, 6));
        assertThat(castle.getPosition(), is(new Cell(5, 6)));
    }

    /**
     * method checks if on the way the figure is another figure.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test
    public void whenCastleMveThenStopMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(castle);
        board.addFigure(bishop);
        board.move(castle.getPosition(), new Cell(7, 2));
        Figure figure = board.findFigure(castle.getPosition());
        assertNotEquals(figure.getPosition(), is(castle.getPosition()));
    }


    /**
     * method move castle in wrond direction.
     *
     * @throws ImposibleMoveExeption wrond direction.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMoveCastleWrongThenThrowExeption() throws ImposibleMoveExeption {
        board.addFigure(castle);
        castle.way(new Cell(6, 4));
    }

    /**
     * method checks whether or not in said cell shape.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = NullPointerException.class)
    public void whenDoNotAddFigyreToBoardThenEXeptionCatch() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(castle);
        board.move(new Cell(3, 3), new Cell(7, 2));

    }
//MOVE THE KNIGHT.

    /**
     * Move knight.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test
    public void whenKnightMveThenSheMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(knight); //65
        board.move(knight.getPosition(), new Cell(7, 3));
        board.move(knight.getPosition(), new Cell(5, 2));
        board.move(knight.getPosition(), new Cell(4, 4));
        board.move(knight.getPosition(), new Cell(5, 6));
        assertThat(knight.getPosition(), is(new Cell(5, 6)));
    }

    /**
     * method checks if on the way the figure is another figure.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenKnightMveThenStopMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(knight);
        board.addFigure(castle);
        board.move(castle.getPosition(), new Cell(7, 3));
        board.move(knight.getPosition(), new Cell(7, 3));
    }

    /**
     * method move knight in wrond direction.
     *
     * @throws ImposibleMoveExeption wrond direction.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMoveKnightWrongThenThrowExeption() throws ImposibleMoveExeption {
        board.addFigure(knight);
        knight.way(new Cell(6, 3));
    }

    //MOVE THE BISHOP.

    /**
     * Move bishop.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test
    public void whenBishopMveThenSheMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(bishop); //55
        board.move(bishop.getPosition(), new Cell(3, 3));
        board.move(bishop.getPosition(), new Cell(2, 4));
        board.move(bishop.getPosition(), new Cell(4, 6));
        board.move(bishop.getPosition(), new Cell(5, 5));
        assertThat(bishop.getPosition(), is(new Cell(5, 5)));
    }

    /**
     * method move bishop in wrond direction.
     *
     * @throws ImposibleMoveExeption wrond direction.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMoveBishopWrongThenThrowExeption() throws ImposibleMoveExeption {
        board.addFigure(bishop);
        bishop.way(new Cell(6, 5));
    }

    /**
     * method checks if on the way the figure is another figure.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenBishopMveThenStopMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(castle);
        board.addFigure(bishop);
        board.move(castle.getPosition(), new Cell(1, 5));
        board.move(bishop.getPosition(), new Cell(3, 3));
        board.move(bishop.getPosition(), new Cell(0, 6));
        Figure figure = board.findFigure(castle.getPosition());
        assertNotEquals(figure.getPosition(), is(castle.getPosition()));
    }
    // MOVE THE KING.

    /**
     * Move king.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test
    public void whenKingMveThenSheMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(king); //45
        board.move(king.getPosition(), new Cell(4, 6));
        board.move(king.getPosition(), new Cell(3, 6));
        board.move(king.getPosition(), new Cell(3, 5));
        board.move(king.getPosition(), new Cell(2, 5));
        assertThat(king.getPosition(), is(new Cell(2, 5)));
    }

    /**
     * method move king in wrond direction.
     *
     * @throws ImposibleMoveExeption wrond direction.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMoveKingWrongThenThrowExeption() throws ImposibleMoveExeption {
        board.addFigure(king);
        king.way(new Cell(4, 3));
    }

    /**
     * method checks if on the way the figure is another figure.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenKingMveThenStopMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(castle);
        board.addFigure(bishop);
        board.move(castle.getPosition(), new Cell(5, 5));
        board.move(king.getPosition(), new Cell(4, 6));
        board.move(king.getPosition(), new Cell(5, 6));
        board.move(king.getPosition(), new Cell(5, 5));

    }
    // MOVE THE QUEEN.

    /**
     * Move queen.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test
    public void whenQueenMveThenSheMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(queen); //35
        board.move(queen.getPosition(), new Cell(7, 1));
        board.move(queen.getPosition(), new Cell(7, 5));
        board.move(queen.getPosition(), new Cell(1, 5));
        board.move(queen.getPosition(), new Cell(3, 7));
        assertThat(queen.getPosition(), is(new Cell(3, 7)));
    }

    /**
     * method move queen in wrond direction.
     *
     * @throws ImposibleMoveExeption wrond direction.
     */
    @Test(expected = ImposibleMoveExeption.class)
    public void whenMoveQueenWrongThenThrowExeption() throws ImposibleMoveExeption {
        board.addFigure(queen);
        queen.way(new Cell(4, 3));
    }

    /**
     * method checks if on the way the figure is another figure.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenQueenMveThenStopMove() throws OccupiedWayException, FigureNotFoundException {
        board.addFigure(castle);
        board.addFigure(queen); //35
        board.move(queen.getPosition(), new Cell(7, 1));
        board.move(queen.getPosition(), new Cell(7, 5));

    }

}