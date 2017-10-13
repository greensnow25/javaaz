package com.greensnow25.repository;

import com.greensnow25.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public class UserSQLRepository implements Repository<User> {
    ConcurrentHashMap<String, Repository> map;

    private UserSQLRepository() {

    }

    private static class Holder {
        private static final UserSQLRepository INSTANCE = new UserSQLRepository();
    }

    public static UserSQLRepository getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void add(User item) {

    }

    @Override
    public void add(Iterable<User> items) {

    }

    @Override
    public void update(User item) {

    }

    @Override
    public void remove(User item) {

    }

    @Override
    public void add(Specification specification) {

    }

    @Override
    public void remove(Specification specification) {

    }

    @Override
    public List<User> query(Specification specification) {
        SqlSpecification sqlSpecification = (SqlSpecification) specification;
        //may be need create connection
        SQLiteDatabase database = openHelper.getReadableDatabase();
        List<User> users = new ArrayList<>();

        Cursor cursor = database.rawQuery(sqlSpecification.toSqlQuery());

        for (int i = 0, size = cursor.getCount(); i < size; i++) {
            cursor.moveToPosition(i);
            newses.add(toNewsMapper.map(cursor));
        }
        cursor.close();
        return newses;
    }
}
