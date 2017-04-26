package com.greensnow25.Input;

import java.util.ArrayList;

/**
 * public class StabInput.
 *
 * @author greensnow25.
 * @version 1.
 * @since 26.04.2017.
 */
public class StabInput implements Input {
    /**
     * list consist with answers.
     */
    private ArrayList<String> list;
    /**
     * position on the list.
     */
    private int pos = 0;

    /**
     * constructor.
     *
     * @param list answers.
     */
    public StabInput(ArrayList<String> list) {
        this.list = new ArrayList<>();
        this.list = list;
    }

    /**
     * method return answers from the list.
     *
     * @param question question.
     * @return answers from the list.
     */
    @Override
    public String ask(String question) {
        return list.get(pos++);
    }
}
