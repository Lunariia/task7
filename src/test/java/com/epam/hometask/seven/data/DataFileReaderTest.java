package com.epam.hometask.seven.data;

import com.epam.hometask.seven.exception.FileDataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataFileReaderTest {

    private static final DataFileReader reader = new DataFileReader();
    private static final String PATH_CUBES = "src/DataFile";

    @Test
    public void readLinesShouldReadWhenFileExist() throws FileDataException {

        //given
        List<String> expected = Arrays.asList("0.0.0 0.1.0 1.1.0 1.0.0 0.0.1 0.1.1 1.1.1 1.0.1", "0.0.0 0.1.0 1.1.0 5.0.0 0.0.1 0.7.1 1.1.1 1.0.1", "0.0.6 0.1.0 1.4.0 1.0.0 6.0.1 0.1.1 1.1.1 1.0.1");
        //when
        List<String> fileData = reader.readLines(PATH_CUBES);
        //then
        Assert.assertEquals(expected, fileData);
    }
}
