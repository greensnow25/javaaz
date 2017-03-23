package com.greensnow25;

import com.greensnow25.input.StubInput;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
     *
     * @param answers answers.
     */
    public void preparation(String[] answers) {
        interactCalculator = new InteractCalculator(new StubInput(answers));
        interactCalculator.run();
    }

    /**
     * add.
     */
    @Test
    public void whenAddThenAddNumber() {
        answers = new String[]{"2+3", "y"};
        preparation(answers);
        assertThat(interactCalculator.getResult(), is(5));

    }

    /**
     * add to result.
     */
    @Test
    public void whenAddSecondTimeThenAToResult() {
        answers = new String[]{"2+3", "+5", "y"};
        preparation(answers);
        assertThat(interactCalculator.getResult(), is(10));
    }

    /**
     * add to result and the.
     */
    @Test
    public void whenAgainAddTwoNumbersThenResultEquelsTheirsSum() {
        answers = new String[]{"2+3", "+5", "4+3", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(7));
    }

    /**
     * sub numbers then add to result.
     */
    @Test
    public void whenSubNumbersThenReturnResult() {
        answers = new String[]{"2-3", "+5", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(4));
    }

    /**
     * split.
     */
    @Test
    public void whenSplitReturnResult() {
        answers = new String[]{"12/3", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(4));
    }

    /**
     * multiply.
     */
    @Test
    public void whenMultiplyNumbersThenReturnResult() {
        answers = new String[]{"2*3", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(6));
    }

    /**
     * first number is negative.
     */
    @Test
    public void whenFirstNumberIsNegativeThenReturnResult() {
        answers = new String[]{"-2-3", "y"};
        preparation(answers);

        assertThat(interactCalculator.getResult(), is(-5));
    }
}