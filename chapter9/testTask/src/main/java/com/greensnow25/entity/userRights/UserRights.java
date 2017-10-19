package com.greensnow25.entity.userRights;

import com.greensnow25.dao.UserDAOImpl;
import com.greensnow25.dataBase.CreateConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Public class UserRights.
 *
 * @author greensnow25.
 * @version 1.
 * @since 18.10.2017.
 */
public class UserRights {

    public CreateConnection connection;

    private List list;

    public UserRights(String role) {
        this.connection = new CreateConnection();
        this.list = new ArrayList();
    }

    public void addRights() {
        for (Rights rights: Rights.values()){

        }
    }
}
