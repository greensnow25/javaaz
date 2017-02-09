package com.greensnow25.chess.exeptions;

/**
 * public exeption, throws if if on the way the figure is another figure.
 * @author greensnow25.
 * @since 08.02.17.
 * @version 1.
 */
public class OccupiedWayException extends Exception {
    /**
     *if on the way the figure is another figure.
     * @param msg exeption massage.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
