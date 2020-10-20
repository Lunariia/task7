package com.epam.hometask.seven.specification;

import com.epam.hometask.seven.model.Cube;

import java.util.List;

public interface Specification<T> {

    boolean specified(T object);

}
