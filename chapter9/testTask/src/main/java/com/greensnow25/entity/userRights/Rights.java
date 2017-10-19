package com.greensnow25.entity.userRights;

import com.greensnow25.dao.Dao;
import com.greensnow25.dao.UserDAOImpl;

import java.sql.Connection;
import java.util.ArrayList;
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


    ADMIN() {
        @Override
        public List<String> getRights() {
            return Arrays.asList("addNewUser", "deleteUser", "editHimself", "editOtherUser");
        }
    },

    MODERATOR() {
        @Override
        public List<String> getRights() {
            return Arrays.asList("addNewUser", "editHimself", "editOtherUser");
        }
    },

    USER() {
        @Override
        public List<String> getRights() {
            return Arrays.asList("editHimself");
        }
    };

    public abstract List<String> getRights();

    Rights() {
    }

}
