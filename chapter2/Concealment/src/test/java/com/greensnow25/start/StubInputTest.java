package com.greensnow25.start;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * test class trow exeption.
 *
 * @author grensow25
 * @version 1.
 * @since 27.01.17.
 */
public class StubInputTest {
    /**
     * error occurs when the key does not exist.
     *
     * @throws MenuOutExeption my exeption.
     */
    @Test(expected = MenuOutExeption.class)
    public void whenTrowExeptionThenExeptionReturn() throws MenuOutExeption {

        List<String> answers = new ArrayList<>();
        answers.add("1");
        StubInput stubInput = new StubInput(answers);
        List<Integer> range = new ArrayList<>();
        range.add(0);
        range.add(2);
        range.add(6);
        stubInput.ask("1", range);

    }

}