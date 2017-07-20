package com.greensnow25.input;

import java.util.Scanner;

/**
 * Public class Input.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Input {
    /**
     * object of class scanner, use for reading from the keyboard.
     */
    private final Scanner sc;

    /**
     * constructor.
     */
    public Input() {
        sc = new Scanner(System.in);
    }

    /**
     * method displays question and read answer from the keyboard.
     *
     * @param question question.
     * @return answer.
     */
    public String answer(String question) {
        System.out.println(question);
        return sc.next();
    }
}
