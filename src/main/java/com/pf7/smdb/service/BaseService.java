package com.pf7.smdb.service;

import java.util.List;

public interface BaseService<T, ID> {

    T create(T obj);

    List<T> createAll(List<T> obj);

    List<T> createAll(T... obj);

    void update(T obj);

    void delete(T obj);

    void deleteById(ID id);

    boolean exists(T obj);

    T find(ID id);

    List<T> findAll();

}
