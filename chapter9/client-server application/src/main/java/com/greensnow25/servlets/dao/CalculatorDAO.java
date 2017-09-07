package com.greensnow25.servlets.dao;

import com.greensnow25.servlets.model.Calc;
import com.greensnow25.servlets.model.Calculator;

/**
 * Public class CalculatorDAO.
 *
 * @author greensnow25.
 * @version 1.
 * @since 07.09.2017.
 */
public class CalculatorDAO {
    /**
     * calc.
     */
    private Calculator calc;

    /**
     * constructor.
     */
    public CalculatorDAO() {
        this.calc = new Calculator();
    }

    /**
     * do something.
     *
     * @param first     first.
     * @param character operations under the numbers.
     * @param second    second.
     * @return result of math operation.
     */
    public int doOperation(int first, String character, int second) {
        int result = 0;
        for (Calc i : this.calc.getOperations()) {
            if (i.info().equals(character)) {
                calc.doSome(first, second);
                result = i.mathOperation();
                break;
            }
        }
        return result;
    }

}
