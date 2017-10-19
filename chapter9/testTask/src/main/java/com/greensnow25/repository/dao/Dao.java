package com.greensnow25.repository.dao;

import java.util.List;

/**
 * Public class UserDao.
 *
 * @author greensnow25.
 * @version 1.
 * @param <E> entity.
 * @since 11.10.2017.
 */
public interface Dao<E> {
    List<E> getAllEntity();

    E getOneByName(String string);

    E getByID(int id);

    boolean create(E entity);

    boolean update(E entity);

    boolean delete(E entity);
}
