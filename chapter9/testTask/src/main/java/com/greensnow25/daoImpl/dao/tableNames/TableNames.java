package com.greensnow25.daoImpl.dao.tableNames;

/**
 * Public class TabelNames.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public enum TableNames {

    user("servlet.controlTask.user"),
    role("servlet.controlTask.role"),
    address("servlet.controlTask.address"),
    musicType("servlet.controlTask.musicType"),
    user_musictype("servlet.controlTask.user_musictype");

    private String description;

    TableNames(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public enum AddressFields {
        id_address, country, city
    }
    public enum UserFields{
id,user,user_role
    }
}
