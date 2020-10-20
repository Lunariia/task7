package com.epam.hometask.seven.repository;

import com.epam.hometask.seven.exception.DataException;
import com.epam.hometask.seven.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface CubeRepository<T> {

    void add(T object) throws DataException;

    void remove(T object) throws DataException;

    void update(T object) throws DataException;

    List<T> query(Specification<T> specification);

    void sort(Comparator<T> comparator);

}
