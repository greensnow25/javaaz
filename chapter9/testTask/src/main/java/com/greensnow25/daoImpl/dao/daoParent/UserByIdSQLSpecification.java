package com.greensnow25.daoImpl.dao.daoParent;

import com.greensnow25.daoImpl.dao.tableNames.TableNames;
import com.greensnow25.repository.SqlSpecification;

/**
 * Public class SQLSpecificationImpl.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public class UserByIdSQLSpecification implements SqlSpecification {
    private int id;

    public UserByIdSQLSpecification(final int id) {
        this.id = id;
    }

    @Override
    public String toSQLQuery() {
        return String.format(
                "SELECT * FROM %1$s WHERE `%2$s` = %3$d';",
                TableNames.user,
                TableNames.UserFields.id,
                id
        );
    }

}
