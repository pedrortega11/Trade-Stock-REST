package com.hackerrank.stocktrade.repository;

import java.util.Collection;
import java.util.function.Predicate;

public interface GenericRepository<T> {


    Collection<T> findAll();

    Collection<T> findAll(Predicate<T> spec);

    T findOne(Predicate<T> spec);

    void save(T entity);

    void delete(T entity);

}
