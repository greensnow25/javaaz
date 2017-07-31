package com.greensnow25.input;

import com.greensnow25.board.Cell;

import java.util.List;

/**
 * Public class Input.
 *
 * @author greensnow25.
 * @version 1.
 * @since 28.07.2017.
 */
public interface Input {
    /**
     * Answer.
     *
     * @param question question.
     * @return answer.
     */
    Cell makeAStep(String question, List<Cell> cellList);
}
