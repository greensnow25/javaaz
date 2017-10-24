package com.greensnow25.hibernate.commad;

/**
 * Public class Comand.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public abstract class Command {
    /**
     * transactions actions.
     */
    private TransactionActions actions;

    public Command(TransactionActions actions) {
        this.actions = actions;
    }

    abstract void execute();

    public TransactionActions getActions() {
        return actions;
    }
}
