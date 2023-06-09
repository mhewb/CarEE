package io.m2i.caree.dao;

import java.util.List;

public interface GenericDAO<T, ID> {

    void create(T entity);

    List<T> findAll();

    T getById(ID id);

    void update(T entity);

    void delete(T entity);

}
