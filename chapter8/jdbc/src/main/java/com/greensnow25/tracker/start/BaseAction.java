package com.greensnow25.tracker.start;

import com.greensnow25.tracker.input.Input;
import com.greensnow25.tracker.input.UserAction;

/**
 * abstract class.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.01.12.
 */
public abstract class BaseAction implements UserAction {
    /**
     * name it is information about the class.
     */
    private String name;

    /**
     *  keyaction.
     */
    private int keyAction;
    /**
     * constructor of class.
     *
     * @param name Information about what the class can do.
     * @param keyAction keyaction.
     */
    public BaseAction(String name, int keyAction) {
        this.name = name;
        this.keyAction = keyAction;
    }

    /**
     * key of actions.
     *
     * @return key of actions.
     */
    public int key() {
        return keyAction;
    }

    /**
     * abstract class.
     *
     * @param input   object of class. choise kind of input.
     * @param tracker object of clas. do actions.
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * information about the class.
     *
     * @return Information about what the class can do.
     */
    public String info() {
        return String.format("%s. %s", this.key(), name);
    }
}
