package com.greensnow25.tracker.start;

import com.greensnow25.tracker.execepion.MenuOutExeption;
import com.greensnow25.tracker.input.Input;

import java.util.List;
import java.util.Scanner;

/**
 * public class ConsoleInput displays a menu to the console and.
 * requests the user's actions.
 *
 * @author greensnow25.
 * @version 1.
 * @since 10.01.17.
 */
public class ConsoleInput implements Input {
    /**
     * Scanner object.
     */

    private Scanner scan = new Scanner(System.in);

    /**
     * override method ask question and returns next word.
     *
     * @param question - whos need ask user.
     * @return returns the first word.
     */

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scan.next();
    }

    @Override
    public int ask(String question, List<Integer> range) throws MenuOutExeption {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;

        for (int value : range) {
            if (key == value) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutExeption("Out of menu range");
        }

    }


}
