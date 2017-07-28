package com.greensnow25.input;

import com.greensnow25.modules.Cell;

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
    Cell inputCell(String question, List<Cell> cellList);
}
