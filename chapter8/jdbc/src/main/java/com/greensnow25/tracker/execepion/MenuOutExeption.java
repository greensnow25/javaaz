package com.greensnow25.tracker.execepion;

/**
 *public class MenuOut Exeption.
 * throw when you out of range.
 * @author greensnow 25.
 * @since 26.10.17.
 * @version 1.
 */
public class MenuOutExeption extends RuntimeException {
    /**
     * Message discarded on error.
     * @param msg exeption.
     */
    public MenuOutExeption(String msg) {
        super(msg);
    }
}
