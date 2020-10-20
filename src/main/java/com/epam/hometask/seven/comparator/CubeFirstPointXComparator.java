package com.epam.hometask.seven.comparator;

import com.epam.hometask.seven.model.Cube;

import java.util.Comparator;

public class CubeFirstPointXComparator implements Comparator<Cube> {

    @Override
    public int compare(Cube cubeOne, Cube cubeTwo) {
        Double first = cubeOne.getPoints().get(0).getCoordinateX();
        Double second = cubeTwo.getPoints().get(0).getCoordinateX();
        return first.compareTo(second);
    }
}
