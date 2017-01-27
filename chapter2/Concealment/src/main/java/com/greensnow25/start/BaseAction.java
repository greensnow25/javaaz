package com.greensnow25.start;

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
     * constructor of class.
     *
     * @param name Information about what the class can do.
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * abstact method.
     *
     * @return key of actions.
     */
    public abstract int key();

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
