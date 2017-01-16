package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;

import java.io.IOException;
import java.util.Scanner;

/**
 *public class ConsoleInput displays a menu to the console and.
 * requests the user's actions.
 * @author greensnow25.
 * @since 10.01.17.
 * @version 1.
 */
public class ConsoleInput implements AutoCloseable, Input  {


    private Scanner scan = new Scanner(System.in);




    @Override
    public void close() throws Exception {
        System.out.print("Закрыто.");
    }

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scan.next();
    }

    @Override
    public int askaction(String question) {
        System.out.println(question);
        return scan.nextInt();
    }


}
