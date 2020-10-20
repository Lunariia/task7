package com.epam.hometask.seven.comparator;

import com.epam.hometask.seven.logic.calculator.CubeCalculator;
import com.epam.hometask.seven.model.Cube;

import java.util.Comparator;

public class CubeAreaComparator implements Comparator<Cube> {

    private CubeCalculator calculator;

    public CubeAreaComparator(CubeCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Cube cubeOne, Cube cubeTwo) {
        Double firstArea = calculator.calculateArea(cubeOne);
        Double secondArea = calculator.calculateArea(cubeTwo);
        return firstArea.compareTo(secondArea);
    }
}
