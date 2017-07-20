package com.greensnow25.entity;

import com.greensnow25.Input;
import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;

import java.util.Scanner;

/**
 * Public class Player.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Player extends Entity {
    Board board;
    private Input input;

    public Player(Board board) {
        this.input = new Input();
        this.board = board;
    }

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
        return new Cell[]{new Cell(x, y)};

    }
}
