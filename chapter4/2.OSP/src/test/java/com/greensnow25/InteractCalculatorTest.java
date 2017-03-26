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
     * run application with trigonometrical.
     *
     * @param answers answers.
     */
    private void preparationTrig(String[] answers) {
        interactCalculator = new Trigonometry(new StubInput(answers));
        interactCalculator.run();
    }

    /**
     * add.
     */
    @Test
    public void whenAddThenAddNumber() {
        answers = new String[]{"2+3", "y"};
        preparationTrig(answers);
        assertThat(interactCalculator.getResult(), is(5d));

    }

    /**
     * add to result.
     */
    @Test
    public void whenAddSecondTimeThenAToResult() {
        answers = new String[]{"2+3", "+5", "y"};
        preparationTrig(answers);
        assertThat(interactCalculator.getResult(), is(10d));
    }

    /**
     * add to result and the.
     */
    @Test
    public void whenAgainAddTwoNumbersThenResultEquelsTheirsSum() {
        answers = new String[]{"2+3", "+5", "4+3", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(7d));
    }

    /**
     * sub numbers then add to result.
     */
    @Test
    public void whenSubNumbersThenReturnResult() {
        answers = new String[]{"2-3", "+5", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(4d));
    }

    /**
     * split.
     */
    @Test
    public void whenSplitReturnResult() {
        answers = new String[]{"12/3", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(4d));
    }

    /**
     * multiply.
     */
    @Test
    public void whenMultiplyNumbersThenReturnResult() {
        answers = new String[]{"2*3", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(6d));
    }

    /**
     * first number is negative.
     */
    @Test
    public void whenFirstNumberIsNegativeThenReturnResult() {
        answers = new String[]{"-2-3", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(-5d));
    }

    /**
     * cos test.
     */
    @Test
    public void whenKeyIsCosThenReturnCosResult() {
        answers = new String[]{"cos60", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(-0.9524129804151563d));
    }

    /**
     * sin test.
     */
    @Test
    public void whenKeyIsSinThenReturnSinResult() {
        answers = new String[]{"sin30", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(-0.9880316240928618d));
    }

    /**
     * tg test.
     */
    @Test
    public void whenKeyIsTgThenReturnTgResult() {
        answers = new String[]{"tg45", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(1.6197751905438615d));
    }

    /**
     * ctg test.
     */
    @Test
    public void whenKeyIsCtgThenReturnCtgResult() {
        answers = new String[]{"ctg30", "y"};
        preparationTrig(answers);

        assertThat(interactCalculator.getResult(), is(1.5374753309166493d));
    }


}