package com.company.library.service.interfaces;

import com.company.library.model.abstracts.Model;

import java.util.List;

public interface ItemService<T extends Model> {

    default List<T> getAll() {
        return null;
    }

    default T getById(int id) {
        return null;
    }

    default void add(T model) {

    }

    default void update(T model) {

    }

    default void delete(int id) {

    }
}
