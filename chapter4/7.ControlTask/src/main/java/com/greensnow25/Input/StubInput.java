package com.greensnow25.Input;

/**
 * public class StubInput.
 *
 * @author greensnow25.
 * @version 1.
 * @since 05.05.2017.
 */
public class StubInput implements Input {
    /**
     * answers.
     */
    private int[] answers;
    /**
     * position in the array.
     */
    private int position = 0;

    /**
     * constructor.
     *
     * @param answers array.
     */
    public StubInput(int[] answers) {
        this.answers = answers;
    }

    /**
     * ask.
     *
     * @param question print question.
     * @return answer.
     */
    @Override
    public int ask(String question) {
        System.out.println(question);
        return answers[position++];
    }
}
