package com.greensnow25.units;

import com.greensnow25.input.Input;
import com.greensnow25.board.Board;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Public class Monster.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
@Immutable
public class Monster extends Unit implements Runnable {

    /**
     * constructor.
     *
     * @param board model.
     * @param input
     */
    public Monster(Board board, Input input) {
        super(board, input);
    }


}
