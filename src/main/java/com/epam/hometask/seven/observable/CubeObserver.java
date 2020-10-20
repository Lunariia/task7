package com.epam.hometask.seven.observable;

import com.epam.hometask.seven.logic.calculator.CubeCalculator;
import com.epam.hometask.seven.model.CubeParameters;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class CubeObserver implements Observer {

    Logger LOGGER = Logger.getLogger(String.valueOf(CubeObserver.class));
    private CubeCalculator calculator;
    private final Map<Integer, CubeParameters> cubeParametersMap = new HashMap<>();
    private static CubeObserver INSTANCE = new CubeObserver();

    private CubeObserver() {
        this.calculator = new CubeCalculator();
    }

    public static CubeObserver getInstance() {
        return INSTANCE;
    }

    @Override
    public void notify(CubeObservable cubeObservable) {

        double area = calculator.calculateArea(cubeObservable);
        double volume = calculator.calculateVolume(cubeObservable);

        CubeParameters parameters = new CubeParameters(area, volume);
        cubeParametersMap.put(cubeObservable.getId(), parameters);

        LOGGER.info("area: " + cubeParametersMap.get(1).getArea());
        LOGGER.info("volume: " + cubeParametersMap.get(1).getVolume());

    }

    //only for test
    public Map<Integer, CubeParameters> getCubeParametersMap() {
        return cubeParametersMap;
    }
}
