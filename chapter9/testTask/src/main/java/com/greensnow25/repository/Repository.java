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

    List<T> query(Specification specification);

}
