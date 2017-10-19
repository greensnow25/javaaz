package com.greensnow25.entity.userRights;

import java.util.Arrays;
import java.util.List;

/**
 * Public class Rights.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public enum Rights {

    /**
     * role.
     */
    ADMIN() {
        @Override
        public List<String> getRights() {
            return Arrays.asList("addNewUser", "deleteUser", "editHimself", "editOtherUser", "showTable");
        }
    },
    /**
     * role.
     */
    MODERATOR() {
        @Override
        public List<String> getRights() {
            return Arrays.asList("addNewUser", "editHimself", "editOtherUser");
        }
    },
    /**
     * role.
     */
    USER() {
        @Override
        public List<String> getRights() {
            return Arrays.asList("editHimself");
        }
    };

    public abstract List<String> getRights();
}
