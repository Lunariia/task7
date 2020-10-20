package com.epam.hometask.seven.logic.calculator;

import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Plane;
import com.epam.hometask.seven.model.Point;

import java.util.ArrayList;
import java.util.List;

public class PointsCalculator {

    public List<Double> getDistanceToPoint(int index, List<Point> points) {
        List<Double> lengths = new ArrayList<>();
        Point startPoint = points.get(index);

        for (int i = 0; i < points.size(); i++) {

            if (i != index) {
                Point endPoint = points.get(i);
                double length = calculateDistance(startPoint, endPoint);
                lengths.add(length);
            }
        }
        return lengths;
    }

    public double calculateDistance(Point startPoint, Point endPoint) {

        double divineX = endPoint.getCoordinateX() - startPoint.getCoordinateX();
        double divineY = endPoint.getCoordinateY() - startPoint.getCoordinateY();
        double divineZ = endPoint.getCoordinateZ() - startPoint.getCoordinateZ();

        double squareOfDivineX = Math.pow(divineX, 2);
        double squareOfDivineY = Math.pow(divineY, 2);
        double squareOfDivineZ = Math.pow(divineZ, 2);

        return Math.sqrt(squareOfDivineX + squareOfDivineY + squareOfDivineZ);
    }

    public double findMinLine(List<Double> distanceToPoints) {
        double minLine = distanceToPoints.get(0);

        for (double length : distanceToPoints) {
            if (length < minLine) {
                minLine = length;
            }
        }
        return minLine;
    }

    public int calculateCount(double minLine, List<Double> distanceToPoints) {
        int count = 0;

        for (double length : distanceToPoints) {
            if (length == minLine) {
                count++;
            }
        }
        return count;
    }

    public double getEdge(List<Point> points) {
        int firstPointIndex = 0;
        List<Double> lengths = getDistanceToPoint(firstPointIndex, points);
        return findMinLine(lengths);
    }

    public double calculateRatioOfTheVolume(Cube cube, Plane plane) {
        List<Point> CubePoints = cube.getPoints();
        List<Point> checkPoints = new ArrayList<>();
        Point p = plane.getPoints().get(0);
        double result = 0;

        for (Point point : CubePoints) {
            if (p.getCoordinateX() == point.getCoordinateX() && p.getCoordinateY() == point.getCoordinateY()) {
                checkPoints.add(point);
            } else if (p.getCoordinateY() == point.getCoordinateY() && p.getCoordinateZ() == point.getCoordinateZ()) {
                checkPoints.add(point);
            }
            if (p.getCoordinateX() == point.getCoordinateX() && p.getCoordinateZ() == point.getCoordinateZ()) {
                checkPoints.add(point);
            }
        }

        Point item = checkPoints.get(0);

        if (p.getCoordinateX() != item.getCoordinateX()) {
            double first = Math.abs(item.getCoordinateX() - p.getCoordinateX());
            double second = cube.getCubeEdge() - first;
            result = (Math.pow(cube.getCubeEdge(), 2) * first / (Math.pow(cube.getCubeEdge(), 2) * second));
        }

        if (p.getCoordinateY() != item.getCoordinateY()) {
            double first = Math.abs(item.getCoordinateY() - p.getCoordinateY());
            double second = cube.getCubeEdge() - first;
            result = (Math.pow(cube.getCubeEdge(), 2) * first / (Math.pow(cube.getCubeEdge(), 2) * second));
        }

        if (p.getCoordinateZ() != item.getCoordinateZ()) {
            double first = Math.abs(item.getCoordinateZ() - p.getCoordinateZ());
            double second = cube.getCubeEdge() - first;
            result = (Math.pow(cube.getCubeEdge(), 2) * first / (Math.pow(cube.getCubeEdge(), 2) * second));
        }
        return result;
    }

    public boolean isOnAxis(List<Point> points) {

        int counterX = 0;
        int counterY = 0;
        int counterZ = 0;

        for (Point point : points) {
            if (point.getCoordinateX() == 0 && point.getCoordinateY() == 0) {
                counterX++;
            }

            if (point.getCoordinateY() == 0 && point.getCoordinateZ() == 0) {
                counterY++;
            }

            if (point.getCoordinateZ() == 0 && point.getCoordinateX() == 0) {
                counterZ++;
            }
        }

        return counterX == 2 && counterY == 2 && counterZ == 2;
    }
}

