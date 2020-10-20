package com.epam.hometask.seven.specification;

import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Point;

public class CubeSpecificationByFirstCoordinate implements Specification<Cube> {

    private double x_point;
    private double y_point;
    private double z_point;

    public CubeSpecificationByFirstCoordinate(double x_point, double y_point, double z_point) {
        this.x_point = x_point;
        this.y_point = y_point;
        this.z_point = z_point;
    }

    @Override
    public boolean specified(Cube cube) {
        Point firstPoint = cube.getPoints().get(0);
        return firstPoint.getCoordinateX() == x_point &&
                firstPoint.getCoordinateY() == y_point &&
                firstPoint.getCoordinateZ() == z_point;
    }
}
