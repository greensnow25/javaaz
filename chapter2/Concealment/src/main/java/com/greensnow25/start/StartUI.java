package com.greensnow25.start;

/**
 * public class StartUI run TRACKER.
 * @author grensnow25.
 * @since 28.12.16.
 * @version 1.0.
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
     * @param input can be consol or emulation.
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
            while (exit) {
                menu.show();
                menu.select(Integer.valueOf(input.ask("Choise action :")));
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
     * @param args string array.
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        new StartUI(input, tracker).choise();
    }



}
