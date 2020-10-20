package com.epam.hometask.seven.logic.calculator;

import com.epam.hometask.seven.model.Cube;

public interface Calculator<T> {

    double calculateArea(T cube);

    double calculateVolume(T cube);
}
