package com.epam.hometask.seven.logic.creator;

import com.epam.hometask.seven.logic.parser.CubeParser;
import com.epam.hometask.seven.logic.parser.PlaneParser;
import com.epam.hometask.seven.logic.validator.CubeValidator;
import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneCreator {

    private final PlaneParser parser;
    private final CubeValidator validator;

    public PlaneCreator(PlaneParser parser, CubeValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public List<Plane> create(List<String> data) {
        List<String> validLines = new ArrayList<>(data.size());
        List<Plane> planes;

        //list of valid strings
        for (String line : data) {
            String trimLine = line.trim();
            if (validator.isValid(trimLine)) {
                validLines.add(trimLine);
            }
        }

        planes = parser.parse(validLines);
        return planes; //Optional.of(cube);
    }
}
