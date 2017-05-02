package com.greensnow25.game;

import com.greensnow25.Input.Input;

/**
 * public class Game.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.04.2017.
 */
public class Game {
    Input input;

private String separator = System.getProperty("line.separator");
    public Game(Input input) {
        this.input = input;
    }

    public void run(){
        do{
            System.out.printf("%s%s%s%s%s%s", "who is begin the game:", separator,"1-user",separator,"2-computer",separator);
            int beginTheGame = input.ask("make a choice: ");
            System.out.printf("%s%s%s%s%s%s","select a figure for the game :",separator,"1-X", separator, "2-O", separator);
            int figure = input.ask("make a choice: ");

        }while ("e")
    }

}
