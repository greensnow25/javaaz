package com.greensnow25.entity;

import com.greensnow25.input.Input;
import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;

/**
 * Public class Player.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Player implements Entity {
    /**
     * object of class Board.
     */
    private Board board;
    /**
     * object of class Input, input system.
     */
    private Input input;

    /**
     * constructor.
     * @param board board.
     */
    public Player(Board board) {
        this.input = new Input();
        this.board = board;
    }

    /**
     * method moves this object on the playing field.
     * @param currentPosition current position of object.
     * @return null;
     */
    @Override
    public Cell[] move(Cell currentPosition) {
        board.getLock().lock();
        int x = Integer.parseInt(input.answer("Enter axis X:  "));
        int y = Integer.parseInt(input.answer("Enter axis Y:  "));
        Cell player = board.getPlayer();
        Player player1 = (Player) player.getEntity();
        player.setEntity(null);
        board.getBoard()[x][y].setEntity(player1);
        board.setPlayer(board.getBoard()[x][y]);
        board.getLock().unlock();
        return null;

    }
}
