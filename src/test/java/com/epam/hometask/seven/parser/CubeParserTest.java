package com.epam.hometask.seven.parser;

import com.epam.hometask.seven.logic.parser.CubeParser;
import com.epam.hometask.seven.logic.validator.CubeValidator;
import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

public class CubeParserTest {

    private static final List<String> VALID_LINES = Arrays.asList("0.0.0 0.1.0 1.1.0 1.0.0 0.0.1 0.1.1 1.1.1 1.0.1");
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
    public void parseShouldParseInObjectWhenDataExist() {

        //given
        CubeValidator validator = Mockito.mock(CubeValidator.class);
        when(validator.isCubesPoints(anyListOf(Point.class))).thenReturn(true);
        CubeParser parser = new CubeParser(validator);
        List<Cube> expected = Arrays.asList(new Cube(1.0, points));

        //when
        List<Cube> cubes = parser.parse(VALID_LINES);
        //then
        Assert.assertEquals(expected, cubes);
    }

    @Test
    public void parseShouldNotParseInObjectWhenDataExist() {

        //given
        CubeValidator validator = Mockito.mock(CubeValidator.class);
        when(validator.isCubesPoints(anyListOf(Point.class))).thenReturn(false);
        CubeParser parser = new CubeParser(validator);
        List<Cube> expected = Arrays.asList(new Cube(1.0, points));

        //when
        List<Cube> cubes = parser.parse(VALID_LINES);
        //then
        Assert.assertEquals(0, cubes.size());

    }


}
