package com.greensnow25.moneyTransfer;

import java.util.Scanner;

/**
 * public class Input.
 *
 * @author greensnow25.
 * @version 1.
 * @since 22.06.2017.
 */
public class Input {

    Scanner sc = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return sc.next();
    }
}
