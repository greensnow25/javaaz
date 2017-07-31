package com.greensnow25.input;

import com.greensnow25.board.Cell;

import java.util.List;

/**
 * Public class MonsterInput.
 *
 * @author greensnow25.
 * @version 1.
 * @since 28.07.2017.
 */
public class MonsterInput implements Input {
    /**
     * Answer.
     *
     * @param question question.
     * @return answer.
     */
    @Override
    public Cell makeAStep(String question, List<Cell> cellList) {
        int i = (int) (Math.random() * cellList.size());
        Cell currentCell = cellList.get(i);
        return currentCell;
    }
}
