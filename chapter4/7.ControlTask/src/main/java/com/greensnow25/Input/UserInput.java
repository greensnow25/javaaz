package com.greensnow25.Input;

import java.util.Scanner;

/**
 * public class UserInput.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class UserInput implements Input {
    /**
     * class object.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * read data fom keyboard.
     *
     * @param question print question.
     * @return answer from user.
     */
    @Override
    public int ask(String question) {
        System.out.println(question);
        return sc.nextInt();
    }
}
