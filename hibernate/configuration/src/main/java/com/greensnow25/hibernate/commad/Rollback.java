package com.greensnow25.hibernate.commad;

/**
 * Public class Rollback.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public class Rollback extends Command {
    public Rollback(TransactionActions actions) {
        super(actions);
    }

    @Override
    public void execute() {
        super.getActions().rollback();
    }
}
