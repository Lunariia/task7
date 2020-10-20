package com.epam.hometask.seven.data;

import com.epam.hometask.seven.exception.FileDataException;

import java.util.List;

public interface DataReader<T> {

    List<T> readLines(String path) throws FileDataException;

}
