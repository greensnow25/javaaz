package com.greensnow25;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * public class BracketsTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.03.2017.
 */
public class BracketsTest {

    @Test
    public void whenCorrectClosingThenReturnTrue(){
        String line = "()(()())";
        Brackets brackets = new Brackets(line);

        assertTrue(brackets.check());
    }
    @Test
    public void whenIncorrectClosingThenReturnTrue(){
        String line = "())()";
        Brackets brackets = new Brackets(line);

        assertFalse(brackets.check());
    }

}