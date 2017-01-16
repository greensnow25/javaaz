package com.greensnow25.start;

import com.greensnow25.modules.Item;
import com.greensnow25.modules.Task;


/**
 *public class ConsoleInput displays a menu to the console and.
 * requests the user's actions.
 * @author greensnow25.
 * @since 10.01.17.
 * @version 1.
 */
public class StubInput implements Input {

  private String[] answers;
    private int position;
    public  StubInput (String[] answers){
        this.answers = answers;
    }


    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int askaction(String question) {
        return 0;
    }
}
