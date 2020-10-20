package com.epam.hometask.seven.logic.creator;

import com.epam.hometask.seven.logic.parser.CubeParser;
import com.epam.hometask.seven.logic.validator.CubeValidator;
import com.epam.hometask.seven.model.Cube;


import java.util.ArrayList;
import java.util.List;

public class CubeCreator {

    private final CubeParser parser;
    private final CubeValidator validator;

    public CubeCreator(CubeParser parser, CubeValidator validator) {
        this.parser = parser;
        this.validator = validator;
    }

    public List<Cube> create(List<String> data) {

        List<String> validLines = new ArrayList<>(data.size());
        List<Cube> cubes;

        //list of valid strings
        for (String line : data) {
            String trimLine = line.trim();
            if (validator.isValid(trimLine)) {
                validLines.add(trimLine);
            }
        }

        cubes = parser.parse(validLines);

        return cubes; //Optional.of(cube);
    }
}
