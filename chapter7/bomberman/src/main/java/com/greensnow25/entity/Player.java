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
public class Player extends Entity {

    /**
     * constructor.
     *
     * @param board board.
     */
    public Player(Board board, Input input) {
        super(board, input);
    }
}
