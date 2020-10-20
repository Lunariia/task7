package com.epam.hometask.seven.logic.calculator;

import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Point;

import java.util.List;

public class CubeCalculator implements Calculator<Cube> {

    private static final int SIDES = 6;

    @Override
    public double calculateArea(Cube cube) {
        return SIDES * Math.pow(cube.getCubeEdge(), 2);
    }

    @Override
    public double calculateVolume(Cube cube) {
        return Math.pow(cube.getCubeEdge(), 3);
    }
}
