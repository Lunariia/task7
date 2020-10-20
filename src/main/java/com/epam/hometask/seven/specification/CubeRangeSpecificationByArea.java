package com.epam.hometask.seven.specification;

import com.epam.hometask.seven.logic.calculator.CubeCalculator;
import com.epam.hometask.seven.model.Cube;

public class CubeRangeSpecificationByArea implements Specification<Cube> {

    private CubeCalculator calculator = new CubeCalculator();
    private double minArea;
    private double maxArea;

    public CubeRangeSpecificationByArea(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    //only for tests
    CubeRangeSpecificationByArea(double minArea, double maxArea, CubeCalculator calculator) {
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.calculator = calculator;
    }


    @Override
    public boolean specified(Cube cube) {
        Double area = calculator.calculateArea(cube);
        return area.compareTo(minArea) >= 0 && area.compareTo(maxArea) <= 0;
    }
}
