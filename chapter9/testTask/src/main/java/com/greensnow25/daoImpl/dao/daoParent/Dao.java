package com.greensnow25.daoImpl.dao.daoParent;

import java.util.List;

/**
 * Public class UserDao.
 *
 * @author greensnow25.
 * @version 1.
 * @since 11.10.2017.
 */
public interface Dao<E> {
    List<E> getAllEntity();

    E getByID(int id);

    void create(E entity);

    void update(E entity);

    void delete(E entity);
}
