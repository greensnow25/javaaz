package com.greensnow25.ConsoleChatLibery;

/**
 * public class using array of words, like input system.
 *
 * @author greensnow25
 * @version 1.
 * @since 06.03.17.
 */
public class StubInput implements Input {
    /**
     * array of answers.
     */
    private String[] answers;
    /**
     * position on array.
     *
     */
    private int position = 0;

    /**
     * constructor of class.
     *
     * @param answers answers array.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * method return answer.
     *
     * @return string from array.
     */
    @Override
    public String answer() {
        return answers[position++];
    }
}
