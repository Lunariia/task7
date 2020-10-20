package com.epam.hometask.seven.data;

import com.epam.hometask.seven.exception.FileDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader implements DataReader<String> {

    public List<String> readLines(String path) throws FileDataException {
        List<String> fileData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                String line = reader.readLine();
                fileData.add(line);
            }
        } catch (IOException e) {
            throw new FileDataException("Can't read a file.", e, path);
        }

        return fileData;
    }
}
