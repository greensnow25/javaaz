package com.greensnow25.start;

import java.util.List;

/**
 * pubic class ValidateInput .
 *
 * @author greensnow25.
 * @version 1.
 * @since 25.01.17.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * method check is key of range.
     * if hot trows exception and treats them.
     * @param question question.
     * @param range of keys.
     * @return key of actions.
     */

    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int valid = -1;
        do {
            try {
                valid = super.ask(question, range);
                invalid = false;

            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate date again");
            }
        } while (invalid);
        return valid;
    }
}
