package com.greensnow25.start;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mama on 27.01.2017.
 */
public class StubInputTest {

    @Test(expected = MenuOutExeption.class)
    public void whenTrowExeptionThenReturnLine() throws MenuOutExeption {
        StubInput stubInput = new StubInput(new String[]{"1"});
        int[] range = new int[]{0,2,6};

        stubInput.ask("1", range);

    }

}