package com.greensnow25.modules;

/**
 * public class Task.
 * @author greensnow25.
 * @since 27.12.16.
 * @version 1.0.
 */

public class Task extends Item {
    /**
     * field comment.
     */
    private Comment comment;
    /**
     * public constructor of class.
     * @param name name of item.
     * @param description description of item.
     */

    public Task(String name, String description) {

        super(name, description);

    }

    /**
     * default constructor of class.
     */
    public Task() {

    }


}
