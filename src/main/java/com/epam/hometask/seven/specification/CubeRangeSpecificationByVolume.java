package com.epam.hometask.seven.specification;

import com.epam.hometask.seven.logic.calculator.CubeCalculator;
import com.epam.hometask.seven.model.Cube;

public class CubeRangeSpecificationByVolume implements Specification<Cube> {

    private CubeCalculator calculator = new CubeCalculator();
    private double minVolume;
    private double maxVolume;

    public CubeRangeSpecificationByVolume(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    //only for tests
    CubeRangeSpecificationByVolume(double minVolume, double maxVolume, CubeCalculator calculator) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(Cube cube) {
        Double volume = calculator.calculateVolume(cube);
        return volume.compareTo(minVolume) >= 0 && volume.compareTo(maxVolume) <= 0;
    }
}
