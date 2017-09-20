package com.greensnow25.model.visitors;

/**
 * Public class ModeratorActions.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.09.2017.
 */
public enum ModeratorActions {
    /**
     *
     */
    EDIT_HIMSELF(true),
    /**
     *
     */
    EDIT_OTHER_USERS(true),
    /**
     *
     */
    EDIT_ROLE(false);
    /**
     *
     */
    private boolean capability;

    ModeratorActions(boolean b) {
        this.capability = b;
    }

    public boolean isCapability() {
        return capability;
    }

    public ModeratorActions[] val() {
        return values();
    }
}
