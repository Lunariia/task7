package com.epam.hometask.seven.logic.validator;

import com.epam.hometask.seven.logic.calculator.PointsCalculator;
import com.epam.hometask.seven.model.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CubeValidator {

    private static final Logger LOGGER = Logger.getLogger(CubeValidator.class.getName());
    private static final String REGEX = "(-?\\d+\\.-?\\d+\\.-?\\d+)";
    private static final Integer LINES_OF_EACH_POINT = 3;
    PointsCalculator calculator = new PointsCalculator();


    public boolean isValid(String line) {
        String[] parts = line.split(" ");

        for (String part : parts) {
            if (!part.matches(REGEX)) {
                LOGGER.warning("This Line isn't valid " + line);
                return false;
            }
        }
        return true;
    }

    public boolean isCubesPoints(List<Point> points) {

        for (int i = 0; i < points.size(); i++) {
            List<Double> distanceToPoints = calculator.getDistanceToPoint(i, points);

            double minLine = calculator.findMinLine(distanceToPoints);
            int equalsLineCount = calculator.calculateCount(minLine, distanceToPoints);

            if (equalsLineCount != LINES_OF_EACH_POINT) {
                return false;
            }
        }
        return true;
    }
}
