package com.greensnow25.hibernate.commad;

/**
 * Public class AddItem.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public class Begin extends Command {

    public Begin(TransactionActions actions) {
        super(actions);
    }

    @Override
    public void execute() {
        super.getActions().beginTransaction();
    }
}
