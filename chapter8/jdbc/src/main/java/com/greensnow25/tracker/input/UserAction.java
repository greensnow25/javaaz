package com.greensnow25.tracker.input;

import com.greensnow25.tracker.start.Tracker;

/**
 * public interface UserAction.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.01.17.
 */
public interface UserAction {
    /**
     * choice key.
     *
     * @return int.
     */
    int key();

    /**
     * do operations from items.
     *
     * @param input   object of class. choise kind of input.
     * @param tracker object of clas. do actions.
     */
    void execute(Input input, Tracker tracker);

    /**
     * info.
     *
     * @return information about what can make the method.
     */
    String info();

}
