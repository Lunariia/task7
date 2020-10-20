package com.epam.hometask.seven.comparator;

import com.epam.hometask.seven.logic.calculator.CubeCalculator;
import com.epam.hometask.seven.model.Cube;

import java.util.Comparator;

public class CubeVolumeComparator implements Comparator<Cube> {

    private CubeCalculator calculator;

    public CubeVolumeComparator(CubeCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Cube cubeOne, Cube cubeTwo) {
        Double firstVolume = calculator.calculateVolume(cubeOne);
        Double secondVolume = calculator.calculateVolume(cubeTwo);
        return firstVolume.compareTo(secondVolume);

    }
}
