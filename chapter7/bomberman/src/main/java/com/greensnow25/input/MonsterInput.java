package com.greensnow25.input;

import com.greensnow25.modules.Cell;
import com.greensnow25.validateData.ValidateData;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public Cell inputCell(String question, List<Cell> cellList) {
        int i = (int) (Math.random() * cellList.size());
        Cell currentCell = cellList.get(i);
        return currentCell;
    }
}
