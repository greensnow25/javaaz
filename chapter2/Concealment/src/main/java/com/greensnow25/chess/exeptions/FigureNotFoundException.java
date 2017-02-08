package com.greensnow25.chess.exeptions;

/**
 * public exeption, throws if figure is not foud.
 * @author greensnow25.
 * @since 08.02.17.
 * @version 1.
 */
public class FigureNotFoundException extends Exception{
    /**
     * method throws exeption, if figure is not found.
     * @param msg massage.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
