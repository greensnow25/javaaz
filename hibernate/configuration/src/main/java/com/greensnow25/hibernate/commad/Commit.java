package com.greensnow25.hibernate.commad;

/**
 * Public class Commit.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public class Commit extends Command {
    public Commit(TransactionActions actions) {
        super(actions);
    }

    @Override
    public void execute() {
        super.getActions().commit();
    }
}
