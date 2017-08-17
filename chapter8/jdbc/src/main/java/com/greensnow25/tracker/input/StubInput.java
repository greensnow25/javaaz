package com.greensnow25.tracker.input;

import com.greensnow25.tracker.execepion.MenuOutExeption;

import java.util.List;

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
    private List<String> answers;
    /**
     * position we use for emulation input.
     */
    private int position = 0;

    /**
     * constructor of the class.
     *
     * @param answers arrayf of Strings.
     */
    public StubInput(List<String> answers) {

        this.answers = answers;
    }

    /**
     * @param question - you may ask anythin.
     * @return array of Srings with position.
     */
    @Override
    public String ask(String question) {
        return answers.get(position++);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(answers.get(position++));
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

