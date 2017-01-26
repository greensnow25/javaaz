package com.greensnow25.start;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * test class trow exeption.
 *
 * @author grensow25
 * @version 1.
 * @since 27.01.17.
 */
public class StubInputTest {

    @Test(expected = MenuOutExeption.class)
    public void whenTrowExeptionThenExeptionReturn() throws MenuOutExeption {
        StubInput stubInput = new StubInput(new String[]{"1"});
        int[] range = new int[]{0, 2, 6};

        stubInput.ask("1", range);

    }

}