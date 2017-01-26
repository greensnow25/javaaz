package com.greensnow25.start;

/**
 * public class ConsoleInput displays a menu to the console and.
 * emulated the user's actions.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.01.17.
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
     *
     * @param answers arrayf of Strings.
     */
    public StubInput(String[] answers) {

        this.answers = answers;
    }

    /**
     * @param question - you may ask anythin.
     * @return array of Srings with position.
     */
    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(answers[position++]);
        boolean invalid = false;
        int valid = -1;
        for (int value : range) {
            if (key == value) {
                invalid = true;
                break;
            }
        }
        if (invalid) {
            return key;
        } else {
            throw new MenuOutExeption("Out of range.");
        }


    }
}

