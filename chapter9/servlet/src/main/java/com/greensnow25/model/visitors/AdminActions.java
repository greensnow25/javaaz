package com.greensnow25.model.visitors;

/**
 * Public class AdminActions.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.09.2017.
 */
public enum AdminActions {


    EDIT_HIMSELF(true),
    EDIT_OTHER_USERS(true),
    EDIT_ROLE(true);

    private boolean capability;

    AdminActions(boolean b) {
        this.capability = b;
    }

    public boolean isCapability() {
        return capability;
    }
}
