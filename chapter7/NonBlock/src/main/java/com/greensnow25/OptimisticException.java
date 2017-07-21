package com.greensnow25;

/**
 * Public class OptimisticException.
 *
 * @author greensnow25.
 * @version 1.
 * @since 21.07.2017.
 */
public class OptimisticException extends RuntimeException {
    /**
     * constructor.
     *
     * @param message msg.
     */
    public OptimisticException(String message) {
        super(message);
    }
}
