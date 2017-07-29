package com.greensnow25.entity;

import com.greensnow25.input.Input;
import com.greensnow25.modules.Board;
import com.greensnow25.modules.Cell;

/**
 * Public class Barrier.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Barrier extends Entity {
    /**
     * constructor.
     *
     * @param board board.
     * @param input
     */
    public Barrier(Board board, Input input) {
        super(board, input);
    }

    /**
     * barrier can not move, always return null;
     *
     * @return
     */

    @Override
    public void run() {
        super.getCurrentCell().lock();
    }
}
