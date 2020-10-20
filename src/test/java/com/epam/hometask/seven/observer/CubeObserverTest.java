package com.epam.hometask.seven.observer;

import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.CubeParameters;
import com.epam.hometask.seven.model.Point;
import com.epam.hometask.seven.observable.CubeObservable;
import com.epam.hometask.seven.observable.CubeObserver;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CubeObserverTest {

    private static final List<Point> POINTS = Arrays.asList(
            new Point(0, 0, 0),
            new Point(0, 1, 0),
            new Point(1, 1, 0),
            new Point(1, 0, 0),
            new Point(0, 0, 1),
            new Point(0, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 0, 1));

    private static final CubeObservable CUBE_OBSERVABLE = new CubeObservable(1, new Cube(1.0, POINTS));
    private final Map<Integer, CubeParameters> cubeParametersMap = new HashMap<>();
    private static final CubeParameters PARAMETERS = new CubeParameters(6.0, 1.0);

    @Test
    public void notifyShouldRecordNewDataWhenItExist() {

        //given
        cubeParametersMap.put(1, PARAMETERS);
        //when
        CubeObserver.getInstance().notify(CUBE_OBSERVABLE);
        //then
        Assert.assertEquals(cubeParametersMap, CubeObserver.getInstance().getCubeParametersMap());
    }
}
