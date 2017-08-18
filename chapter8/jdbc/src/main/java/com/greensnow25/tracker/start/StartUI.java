package com.greensnow25.tracker.start;

import com.greensnow25.tracker.database.MyBase;
import com.greensnow25.tracker.execepion.MenuOutExeption;
import com.greensnow25.tracker.input.Input;
import com.greensnow25.tracker.validData.ValidateInput;

/**
 * public class StartUI run TRACKER.
 *
 * @author grensnow25.
 * @version 1.0.
 * @since 28.12.16.
 */
public class StartUI {
    /**
     * initialization.
     */
    private Input input;
    /**
     * initialization.
     */
    private Tracker tracker;

    /**
     * constructor of class.
     *
     * @param input   can be consol or emulation.
     * @param tracker add tracker.
     */
    StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * method performs actions with items.
     */
    public void choise() {
        MenuTracker menu = new MenuTracker(input, tracker);

        boolean exit = true;
        try {
            menu.filling();
            menu.showKeys();
            while (exit) {
                menu.show();
                try {
                    menu.select(input.ask("Choise action :", menu.getRange()));
                } catch (MenuOutExeption ex) {
                    System.out.println(ex.getMessage());
                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
                if ("y".equals(input.ask("Exit y/ n"))) {
                    break;
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * main.
     *
     * @param args string array.
     */
    public static void main(String[] args) {
        Tracker tracker = new MyBase();
        Input input = new ValidateInput();
        new StartUI(input, tracker).choise();
    }


}
