package com.greensnow25.ConsoleChatLibery;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * public class create, for using manual input.
 *
 * @author greensnow25
 * @version 1.
 * @since 06.03.17.
 */
public class ConsoleInput implements Input {
    /**
     * default constructor.
     */
    public ConsoleInput() {

    }
    /**
     * mentod use input system from keyboard.
     *
     * @return entered string.
     * @throws IOException ex.
     */
    @Override
    public String answer() throws IOException {
        String word = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            word = br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return word;
    }
}
