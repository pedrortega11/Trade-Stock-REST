package com.hackerrank.stocktrade.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

abstract class LocalRepository<T> implements GenericRepository<T> {
    private final Set<T> entities;

    LocalRepository() {
        this.entities = new HashSet<T>();
    }

    @Override
    public Collection<T> findAll() {
        return entities;
    }

    @Override
    public List<T> findAll(Predicate<T> spec) {
        return entities.stream().filter(spec).collect(Collectors.toList());
    }

    @Override
    public T findOne(Predicate<T> spec) {
        return entities.stream().filter(spec).findFirst().orElse(null);
    }

    @Override
    public void save(T entity) {
        this.entities.add(entity);
    }

    @Override
    public void delete(T entity) {
        this.entities.remove(entity);
    }

    public void clear() {
        this.entities.clear();
    }
}
