package com.greensnow25.chess.exeptions;
/**
 * public exeption, throws if wrong color of figure.
 * or figure do not move that.
 * @author greensnow25.
 * @since 08.02.17.
 * @version 1.
 */
public class ImposibleMoveExeption extends Exception {
    /**
     * if wrong color of figure or figure do not move that.
     * @param msg massage about exeption.
     */
    public ImposibleMoveExeption(String msg) {
        super(msg);
    }
}
