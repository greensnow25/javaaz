package com.greensnow25.input;

/**
 * public class StubInput.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.03.2017.
 */
public class StubInput implements Input {
    /**
     * answers.
     */
    private String[] answers;
    /**
     * position.
     */
    private int position = 0;

    /**
     * class constructor.
     *
     * @param line answers.
     */
    public StubInput(String[] line) {
        this.answers = line;
    }

    @Override
    public String answer(String question) {
        return answers[position++];
    }
}
