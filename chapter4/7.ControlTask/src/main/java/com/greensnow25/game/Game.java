package com.greensnow25.game;

import com.greensnow25.Board;
import com.greensnow25.Input.Input;
import com.greensnow25.Input.UserInput;
import com.greensnow25.firstMove.Computer;
import com.greensnow25.firstMove.Player;
import com.greensnow25.firstMove.User;
import com.greensnow25.genrgateField.GenerateCompMove;
import com.greensnow25.board.Figure;

import java.util.ArrayList;
import java.util.List;

/**
 * public class Game.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class Game {
    /**
     * run game.
     * @param args args.
     */
    public static void main(String[] args) {
        Game game = new Game(new UserInput());
        game.run();
    }

    /**
     * input system.
     */
    private Input input;
    /**
     * class object, field for the game.
     */
    private Board board;
    /**
     * Collection of rules for the game.
     */
    private List<Rule> rules;
    /**
     *
     */
    private final int conditionForWin;

    /**
     * class constructor.
     *
     * @param input system.
     */
    public Game(Input input) {
        this.input = input;
        this.board = new Board(input.ask("enter size of field: "));
        this.conditionForWin = input.ask("Enter the necessary sequence of pieces to win");
        this.rules = new ArrayList<>();
    }

    /**
     * method run application.
     */
    public void run() {
        String separator = System.getProperty("line.separator");
        //add rules.
        this.addRules();

        System.out.printf("%s%s%s%s%s%s", "who is begin the game:", separator, "1-user", separator, "2-computer", separator);
        int beginTheGame = input.ask("make a choice: ");
        System.out.printf("%s%s%s%s%s%s", "select a figure for the game :", separator, "1-X", separator, "2-O", separator);
        int figure = input.ask("make a choice: ");

        Player playerOne = new User();
        Player playerTwo = new Computer(new GenerateCompMove());
        // who starts the game.
        if (playerOne.moveFirst(beginTheGame) instanceof Computer) {
            playerOne = playerTwo;
            playerTwo = new User();
        }

        while (true) {
            Figure figOne = playerOne.makeMove(board, input, figure);
            board.showBoard();
            if (this.checkWinOrNoMoves(board, figOne, playerOne)) {
                break;
            }
            Figure figTwo = playerTwo.makeMove(board, input, figure);
            board.showBoard();
            if (this.checkWinOrNoMoves(board, figTwo, playerTwo)) {
                break;
            }
        }
    }

    /**
     * add rules to collection.
     */
    public void addRules() {
        rules.add(new RulesDiagonal());
        rules.add(new RuleColumn());
    }

    /**
     * method check conditions for victory.
     *
     * @param board           field for the game.
     * @param lastFigure      current figure.
     * @param conditionForWin Necessary sequence of figures necessary for victory.
     * @return result.
     */
    public boolean checWin(Board board, Figure lastFigure, int conditionForWin) {
        boolean result = false;
        for (Rule rule : this.rules) {
            if (rule.check(board, lastFigure, conditionForWin)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * check.
     * @param board  field for the game.
     * @param fig    current figure.
     * @param player Player who makes a move.
     * @return boolean.
     */
    public boolean checkWinOrNoMoves(Board board, Figure fig, Player player) {
        if (checWin(board, fig, conditionForWin)) {
            System.out.println(player.getClass() + " win");
            return true;
        } else if (board.noMoves()) {
            System.out.println("no moves. game over");
            return true;
        }
        return false;
    }
}
