package com.epam.hometask.seven.repository;

import com.epam.hometask.seven.exception.DataException;
import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.specification.Specification;

import java.util.*;

public class CubeRepositoryImpl implements CubeRepository<Cube> {

    private static final String EXCEPTION_MESSAGE_EXIST = "Repository contain this item: ";
    private static final String EXCEPTION_MESSAGE_NOT_EXIST = "Repository doesn't contain this item: ";

    private List<Cube> cubes = new ArrayList<>();
    Iterator<Cube> iter = cubes.iterator();

    @Override
    public void add(Cube cube) throws DataException {
        if (cubes.contains(cube)) {
            throw new DataException(EXCEPTION_MESSAGE_EXIST + cube);
        }
        cubes.add(cube);
    }

    @Override
    public void remove(Cube cube) throws DataException {
        if (!cubes.contains(cube)) {
            throw new DataException(EXCEPTION_MESSAGE_NOT_EXIST + cube);
        }
        cubes.remove(cube);
    }

    @Override
    public void update(Cube cube) throws DataException {
        double edge = cube.getCubeEdge();
        Cube methodCube;
        int i = 0;
        while (i < cubes.size()) {
            methodCube = cubes.get(i);
            if (methodCube.getCubeEdge() == edge) {
                remove(cube);
            }
        }
//        while (iter.hasNext()) {
//            Cube methodCube = iter.next();
//            if (methodCube.getCubeEdge() == edge) {
//                iter.remove();
//            }
//        }
    }

    @Override
    public List<Cube> query(Specification<Cube> specification) {
        List<Cube> cubeSpecified = new LinkedList<>();
        for (Cube cube : cubes) {
            if (specification.specified(cube)) {
                cubeSpecified.add(cube);
            }
        }
        return cubeSpecified;
    }

    @Override
    public void sort(Comparator<Cube> comparator) {
        Collections.sort(cubes, comparator);
    }

    //for tests
    public List<Cube> getCubes() {
        return cubes;
    }
}
