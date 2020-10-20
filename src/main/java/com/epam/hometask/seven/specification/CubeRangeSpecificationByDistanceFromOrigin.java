package com.epam.hometask.seven.specification;

import com.epam.hometask.seven.logic.calculator.PointsCalculator;
import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Point;

import java.util.ArrayList;
import java.util.List;

public class CubeRangeSpecificationByDistanceFromOrigin implements Specification<Cube> {

    private final double minDistance;
    private final double maxDistance;
    private PointsCalculator calculator = new PointsCalculator();

    public CubeRangeSpecificationByDistanceFromOrigin(double minDistance, double maxDistance) {
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
    }

    //forTest
    CubeRangeSpecificationByDistanceFromOrigin(double minDistance, double maxDistance, PointsCalculator calculator) {
        this.minDistance = minDistance;
        this.maxDistance = maxDistance;
        this.calculator = calculator;
    }

    @Override
    public boolean specified(Cube cube) {
        Point originPoint = new Point(0.0, 0.0, 0.0);
        List<Point> points = cube.getPoints();
        List<Double> distances = new ArrayList<>();

        for (Point point : points) {
            distances.add(calculator.calculateDistance(originPoint, point));
        }

        Double minLength = calculator.findMinLine(distances);

        return minLength.compareTo(minDistance) >= 0 && minLength.compareTo(maxDistance) <= 0;
    }
}
