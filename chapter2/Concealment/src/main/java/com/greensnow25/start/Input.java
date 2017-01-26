package com.greensnow25.start;

/**
 *  inteface Input we use to determine the input method.
 *  @author greensnow25.
 *  @since 17.01.17'
 *  @version 1.
 */
public interface Input {
    /**
     * abstrack method ask.
     * @param question - you may ask anythin.
     * @return String.
     */
    String ask(String question);

    /**
     * method with parametrs.
     * @param question whos you like to ask.
     * @param range of actions.
     * @return key.
     */
    int ask(String question, int[] range);
}

