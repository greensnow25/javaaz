package com.greensnow25.hibernate.commad;

import org.hibernate.Transaction;

/**
 * Public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.10.2017.
 */
public class TransactionActions {
    /**
     * transaction.
     */
    private Transaction transaction;

    /**
     * constructor.
     *
     * @param transaction tr.
     */
    public TransactionActions(Transaction transaction) {
        this.transaction = transaction;
    }

    public void beginTransaction() {
        this.transaction.begin();
    }

    public void commit() {
        this.transaction.commit();
    }

    public void rollback() {
        this.transaction.rollback();
    }
}
