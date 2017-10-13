package com.greensnow25.repository;

import java.util.List;

/**
 * Public class Repository.
 *
 * @author greensnow25.
 * @version 1.
 * @since 12.10.2017.
 */
public interface Repository<T> {

    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    void remove(T item);

    void add(Specification specification);

    void remove(Specification specification);

    List<T> query(Specification specification);

}
