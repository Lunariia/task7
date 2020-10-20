package com.epam.hometask.seven.logic;

import com.epam.hometask.seven.logic.calculator.PointsCalculator;
import com.epam.hometask.seven.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class PointsCalculatorTest {

    private static PointsCalculator pointCalculator = new PointsCalculator();
    private static final List<Point> POINTS = Arrays.asList(new Point(0, 0, 0), new Point(0, 1, 0));

    @Test
    public void getDistanceToPointShouldCalculateLength() {

        //given
        List<Double> expected = Arrays.asList(1.0);
        //when
        List<Double> list = pointCalculator.getDistanceToPoint(0, POINTS);
        //then
        Assert.assertEquals(expected, list);
    }

    @Test
    public void calculateDistanceShouldCalculatedDistanceBetweenPoints() {

        //given
        double expected = 1.0;
        //when
        double result = pointCalculator.calculateDistance(POINTS.get(0), POINTS.get(1));
        //then
        Assert.assertEquals(expected, result, 1);
    }

    @Test
    public void findMinLineShouldCalculatedMinValue() {

        //given
        double expected = 1.0;
        List<Double> distanceToPoints = Arrays.asList(1.0, 2.0, 3.0);
        //when
        double result = pointCalculator.findMinLine(distanceToPoints);
        //then
        Assert.assertEquals(expected, result, 1);
    }

    @Test
    public void calculateCountShouldReturnAmountFromList() {

        //given
        double expected = 1.0;
        List<Double> distanceToPoints = Arrays.asList(1.0, 2.0, 3.0);
        //when
        double result = pointCalculator.calculateCount(1.0, distanceToPoints);
        //then
        Assert.assertEquals(expected, result, 1);
    }

    @Test
    public void getEdgeShouldReturnEdgeWhenHavePoints() {

        double expected = 1.0;
        double edge = pointCalculator.getEdge(POINTS);
        Assert.assertEquals(expected, edge, 1);
    }
}
