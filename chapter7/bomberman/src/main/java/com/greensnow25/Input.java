package com.greensnow25;

import java.util.Scanner;

/**
 * Public class Input.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.07.2017.
 */
public class Input {
    private final Scanner sc;

    public Input() {
        sc = new Scanner(System.in);
    }

    public String answer(String question) {
        System.out.println(question);
        return sc.next();
    }
}
