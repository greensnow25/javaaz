package com.greensnow25.input;

import java.util.Scanner;

/**
 * public class ConsolInput.
 *
 * @author greensnow25.
 * @version 1.
 * @since 20.03.2017.
 */
public class ConsolInput implements Input{
    private Scanner sc = new Scanner(System.in);
    @Override
    public String answer(String question) {

        return sc.nextLine();
    }
}
