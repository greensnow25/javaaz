package com.greensnow25.model.visitors;

/**
 * Public class UserAction.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.09.2017.
 */
public enum UserAction {

    EDIT_HIMSELF(true),
    EDIT_OTHER_USERS(false),
    EDIT_ROLE(false);

    private boolean capability;

    UserAction(boolean b) {
        this.capability = b;
    }

    public boolean isCapability() {
        return capability;
    }
}
