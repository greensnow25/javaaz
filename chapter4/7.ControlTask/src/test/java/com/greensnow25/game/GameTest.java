package com.greensnow25.game;

import com.greensnow25.Board;
import com.greensnow25.genrgateField.GenerateCompMove;
import com.greensnow25.board.Cross;
import com.greensnow25.board.Figure;
import com.greensnow25.board.Naught;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * public class GameTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 05.05.2017.
 */
public class GameTest {

    /**
     * class object.
     */
    private Board board;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTset() {
        this.board = new Board();
    }

    /**
     * test add figure to the field for the game.
     */
    @Test
    public void whenFigureAddToTheBoardThenCheckFigureOnTheBoard() {
        Cross cross = new Cross(0, 0);

        board.addFigure(cross);
        Figure result = board.getFigures()[0][0];

        assertThat(cross, is(result));

    }

    /**
     * test when the specified cell is busy.
     */
    @Test
    public void whenTheSpecifiedCellIsBusyThenReturnFalse() {

        board.addFigure(new Cross(0, 0));
        boolean result = board.addFigure(new Cross(0, 0));

        assertFalse(result);
    }

    /**
     * show game field.
     */
    @Test
    public void whenRunShowBoardThenPrint() {
        board.addFigure(new Cross(0, 0));
        board.addFigure(new Naught(1, 1));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        board.showBoard();
        String res = out.toString();
        String sep = System.getProperty("line.separator");
        assertThat(res, is(" X  |  | " + sep
                + sep + " |  O  | " + sep
                + sep + " |  |  | " + sep + sep));
    }


    /**
     * if all field are busy, return true.
     */
    @Test
    public void whenAllFieldsAreBusyThenReturnTrue() {
        for (int i = 0; i != board.getFigures().length; i++) {
            for (int j = 0; j != board.getFigures()[i].length; j++) {
                board.addFigure(new Cross(i, j));
            }
        }
        boolean result = board.noMoves();

        assertTrue(result);
    }


    /**
     * test generate move for computer.
     */
    @Test
    public void whenMethodRunThenReturnTry() {
        GenerateCompMove move = new GenerateCompMove();
        Cross cross = new Cross();
        move.generate(board, cross);
        Figure figure = null;
        for (int i = 0; i != board.getFigures().length; i++) {
            for (int j = 0; j != board.getFigures()[i].length; j++) {
                if (board.getFigures()[i][j] != null) {
                    figure = board.getFigures()[i][j];
                    break;
                }
            }
        }
        assertThat(cross, is(figure));
    }

    /**
     * test rule diagonal.
     */
    @Test
    public void whenFiguresLocatedOnSameDiagonalAndCountEqualsValueCountForWinThenReturnTrue() {
        board.addFigure(new Cross(0, 0));
        board.addFigure(new Cross(2, 2));
        Cross cross = new Cross(1, 1);
        board.addFigure(cross);

        RulesDiagonal rule = new RulesDiagonal();
        boolean res = rule.check(this.board, cross, 3);

        assertTrue(res);
    }

    /**
     * test rule diagonal. different figures on diagonal.
     */
    @Test
    public void whenFiguresLocatedOnSameDiagonalAndCountEqualsValueCountForWinDifferentFiguresThenReturnFalse() {
        board.addFigure(new Cross(0, 0));
        board.addFigure(new Cross(2, 2));
        Naught naught = new Naught(1, 1);
        board.addFigure(naught);

        RulesDiagonal rule = new RulesDiagonal();
        boolean res = rule.check(this.board, naught, 3);

        assertFalse(res);
    }

    /**
     * test rule column return true, if carry out conditions namely in column must be three figures.
     * of the same type.
     */
    @Test
    public void whenRunCheckThenReturnTrue() {
        board.addFigure(new Cross(0, 0));
        board.addFigure(new Cross(0, 2));
        Cross cross = new Cross(0, 1);
        board.addFigure(cross);

        RuleColumn rule = new RuleColumn();
        boolean res = rule.check(this.board, cross, 3);

        assertTrue(res);
    }


    /**
     * test rule column return false, if carry out conditions namely in column must be three figures.
     * of the different type.
     */
    @Test
    public void whenRunCheckThenReturnFalse() {
        board.addFigure(new Cross(0, 0));
        board.addFigure(new Cross(0, 2));
        Naught naught = new Naught(0, 1);
        board.addFigure(naught);


        RuleColumn rule = new RuleColumn();
        boolean res = rule.check(this.board, naught, 3);

        assertFalse(res);
    }

}














