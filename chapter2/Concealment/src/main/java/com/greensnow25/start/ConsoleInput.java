package com.greensnow25.start;

import java.util.Scanner;

/**
 *public class ConsoleInput displays a menu to the console and.
 * requests the user's actions.
 * @author greensnow25.
 * @since 10.01.17.
 * @version 1.
 */
public class ConsoleInput implements Input  {
    /**
     * Scanner obgect.
     */

    private Scanner scan = new Scanner(System.in);

    /**
     * override method ask question and returns next word.
     * @param question - whos need ask user.
     * @return returns the first word.
     */

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scan.next();
    }




}
