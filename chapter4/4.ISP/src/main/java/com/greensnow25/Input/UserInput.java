package com.greensnow25.Input;

import java.util.Scanner;

/**
 * public class UserInput.
 *
 * @author greensnow25.
 * @version 1.
 * @since 26.04.2017.
 */
public class UserInput implements Input {
    /**
     * scanner.
     */
    private Scanner sc;

    /**
     * constructor.
     */
    public UserInput() {
        this.sc = new Scanner(System.in);
    }

    /**
     * user input.
     *
     * @param question question.
     * @return amswer.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return sc.nextLine();
    }
}
