package com.epam.hometask.seven.repository;

import com.epam.hometask.seven.comparator.CubeAreaComparator;
import com.epam.hometask.seven.comparator.CubeVolumeComparator;
import com.epam.hometask.seven.exception.DataException;
import com.epam.hometask.seven.logic.calculator.CubeCalculator;
import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Point;
import com.epam.hometask.seven.specification.CubeRangeSpecificationByVolume;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubeRepositoryImplTest {

    private static final CubeAreaComparator AREA_COMPARATOR = new CubeAreaComparator(new CubeCalculator());
    private static final CubeRangeSpecificationByVolume VOLUME = new CubeRangeSpecificationByVolume(0.0,10.0);
    private static final CubeRepositoryImpl repository = new CubeRepositoryImpl();

    private static final List<Point> FIRST_POINTS = Arrays.asList(
            new Point(0, 0, 0),
            new Point(0, 1, 0),
            new Point(1, 1, 0),
            new Point(1, 0, 0),
            new Point(0, 0, 1),
            new Point(0, 1, 1),
            new Point(1, 1, 1),
            new Point(1, 0, 1));

    private static final List<Point> SECOND_POINTS = Arrays.asList(
            new Point(0,0,0),
            new Point(0,3,0),
            new Point(3,3,0),
            new Point(3,0,0),
            new Point(0,0,3),
            new Point(0,3,3),
            new Point(3,3,3),
            new Point(3,0,3));

    private static final Cube CUBE_ONE = new Cube(1.0,FIRST_POINTS);
    private static final Cube CUBE_TWO = new Cube(3.0,SECOND_POINTS);
    private List<Cube> expected = new ArrayList<>();

    @Test
    public void addShouldAddItemWhenItExist() throws DataException {

        //given
        expected.add(CUBE_ONE);
        //when
        repository.add(CUBE_ONE);
        //then
        Assert.assertEquals(expected.get(0), repository.getCubes().get(0));
    }


    @Test
    public void removeShouldDeleteItemWhenItExist() throws DataException {
        //given
        repository.add(CUBE_ONE);
        //when
        repository.remove(CUBE_ONE);
        //then
        Assert.assertEquals(expected.size(),repository.getCubes().size());
    }

    @Test
    public void updateShouldUpdateItemWhenItExist() throws DataException {
        //given
        repository.add(CUBE_ONE);
        //when
        repository.update(CUBE_ONE);
        //then
        Assert.assertEquals(expected.size(),repository.getCubes().size());
    }

    @Test
    public void queryShouldReturnItemsWhenItValid() throws DataException {
        //given
        expected.add(CUBE_ONE);

        repository.add(CUBE_ONE);
        repository.add(CUBE_TWO);
        //when
        List<Cube> result = repository.query(VOLUME);
        //then
        Assert.assertEquals(expected,result);
    }

    @Test
    public void sortShouldReturnRightOrderOfElements() throws DataException {
        //given
        expected.add(CUBE_ONE);
        expected.add(CUBE_TWO);

        repository.add(CUBE_TWO);
        repository.add(CUBE_ONE);
        //when
        repository.sort(AREA_COMPARATOR);
        //then
        Assert.assertEquals(expected,repository.getCubes());
    }

}
