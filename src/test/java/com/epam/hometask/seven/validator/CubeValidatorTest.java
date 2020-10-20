package com.epam.hometask.seven.validator;

import com.epam.hometask.seven.logic.validator.CubeValidator;
import com.epam.hometask.seven.model.Point;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class CubeValidatorTest {

    private static final CubeValidator validator = new CubeValidator();
    private static final String DATA = "0.0.0 0.1.0 1.1.0 1.0.0 0.0.1 0.1.1 1.1.1 1.0.1";
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
    public void isValidShouldReturnTrueWhenValid() {

        //when
        boolean result = validator.isValid(DATA);
        //then
        Assert.assertEquals(true, result);

    }

    @Test
    public void isCubePointsShouldReturnTrueWhenIsCube() {

        //when
        boolean result = validator.isCubesPoints(points);
        //then
        Assert.assertEquals(true, result);

    }


}
