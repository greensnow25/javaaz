package com.greensnow25.start;

import java.util.List;

/**
 * public class ValidStubInput.
 * Emulait user actions and throw exeption if
 * user out of range or user enter incorect data.
 *
 * @author greensnow25.
 * @version 1.
 * @since 26.01.17.
 */
public class ValidStubInput extends StubInput {

    /**
     * constructor of the class.
     *
     * @param answers arrayf of Strings.
     */
    public ValidStubInput(List<String> answers) {
        super(answers);
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int valid = -1;
        boolean invalid = true;
        do {
            try {
                valid = super.ask(question, range);
                invalid = false;

            } catch (MenuOutExeption e) {
                System.out.print("Out of range. Try again.");

            } catch (NumberFormatException e) {
                System.out.print("Incorect data.");
            }

        } while (invalid);

        return valid;
    }
}
