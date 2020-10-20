package com.epam.hometask.seven.logic.parser;

import com.epam.hometask.seven.logic.calculator.PointsCalculator;
import com.epam.hometask.seven.logic.validator.CubeValidator;
import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Plane;
import com.epam.hometask.seven.model.Point;

import java.util.ArrayList;
import java.util.List;

public class PlaneParser {

    private final CubeValidator validator;

    public PlaneParser(CubeValidator validator) {
        this.validator = validator;
    }

    public List<Plane> parse(List<String> validLines) {

        List<Point> points = new ArrayList<>();
        List<Plane> planes = new ArrayList<>();

        for (String valid : validLines) {
            String[] coordinate = valid.split(" ");

            for (String str : coordinate) {
                String trimLine = str.replaceAll("\\.", " ").trim();
                String[] sub = trimLine.split(" ");

                double coordinateX = Double.parseDouble(sub[0]);
                double coordinateY = Double.parseDouble(sub[1]);
                double coordinateZ = Double.parseDouble(sub[2]);

                Point point = new Point(coordinateX, coordinateY, coordinateZ);
                points.add(point);

            }

            List<Point> tmpPoints = new ArrayList<>(points);
            planes.add(new Plane(tmpPoints));

            points.clear();
        }

        return planes;
    }
}
