package com.greensnow25;

import com.greensnow25.input.StubInput;
import org.junit.Before;
import org.junit.Test;

import java.net.Socket;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * public class InteractCalculatorTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.03.2017.
 */
public class InteractCalculatorTest {
    /**
     * class object.
     */
    private InteractCalculator interactCalculator;
    /**
     * test answers.
     */
    private String[] answers;

    /**
     * run aplication.
     * @param answers answers.
     */
    public void preparation(String[] answers) {
        interactCalculator = new InteractCalculator(new StubInput(answers));
        interactCalculator.choise();
    }

    @Test
    public void whenAddThenAddNumber() {
        answers = new String[]{"2+3", "y"};
        preparation(answers);
        assertThat(interactCalculator.getResult(), is(5));

    }

    @Test
    public void whenAddSecondTimeThenAToResult() {
        answers = new String[]{"2+3", "+5", "y"};
        preparation(answers);
        assertThat(interactCalculator.getResult(), is(10));
    }

    @Test
    public void whenAgainAddTwoNumbersThenResultEquelsTheirsSum() {
        answers = new String[]{"2+3", "+5", "4+3", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(7));
    }


    @Test
    public void whenSubNumbersThenREturnResult() {
        answers = new String[]{"2-3", "+5", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(4));
    }

    @Test
    public void whenSplitReturnResult() {
        answers = new String[]{"12/3", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(4));
    }

    @Test
    public void whenMultiplyNumbersThenReturnResult() {
        answers = new String[]{"2*3", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(6));
    }
}