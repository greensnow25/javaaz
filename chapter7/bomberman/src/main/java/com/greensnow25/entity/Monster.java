package com.greensnow25.entity;

import com.greensnow25.input.Input;
import com.greensnow25.modules.Board;
import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Public class Monster.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
@Immutable
public class Monster extends Entity implements Runnable {

    /**
     * constructor.
     *
     * @param board board.
     * @param input
     */
    public Monster(Board board, Input input) {
        super(board, input);
    }


}
