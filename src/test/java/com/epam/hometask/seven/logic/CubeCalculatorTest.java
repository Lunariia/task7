package com.epam.hometask.seven.logic;

import com.epam.hometask.seven.logic.calculator.CubeCalculator;
import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeCalculatorTest {

    CubeCalculator calculator = new CubeCalculator();
    private static final List<Point> points = Arrays.asList(
            new Point(0, 0, 0),
            new Point(0, 1, 0),
            new Point(1, 1, 0),
            new Point(1, 0, 0),
            new Point(0, 0, 1),
            new Point(0, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 0, 1));

    @Test
    public void calculateAreaShouldCalculateWhenHaveCube() {

        //given
        Cube cube = new Cube(1, points);
        //when
        double area = calculator.calculateArea(cube);
        //then
        Assert.assertEquals(6, area, 6);
    }

    @Test
    public void calculateVolumeShouldCalculateWhenHaveCube() {

        //given
        Cube cube = new Cube(1, points);
        //when
        double volume = calculator.calculateVolume(cube);
        //then
        Assert.assertEquals(1, volume, 1);
    }

}
