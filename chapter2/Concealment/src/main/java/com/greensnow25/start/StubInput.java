package com.greensnow25.start;

/**
 *public class ConsoleInput displays a menu to the console and.
 * emulated the user's actions.
 * @author greensnow25.
 * @since 10.01.17.
 * @version 1.
 */
public class StubInput implements Input {
    /**
     * araay of Strings in it we write our actions.
     */
    private String[] answers;
    /**
     * position we use for emulation input.
     */
    private int position = 0;

    /**
     * constructor of the class.
     * @param answers arrayf of Strings.
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     *
     * @param question - you may ask anythin.
     * @return array of Srings with position.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }
}

