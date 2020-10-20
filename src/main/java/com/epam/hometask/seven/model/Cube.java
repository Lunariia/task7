package com.epam.hometask.seven.model;


import java.util.List;
import java.util.Objects;

public class Cube {

    private double cubeEdge;
    private List<Point> points;

    public Cube(double cubeEdge, List<Point> points) {
        this.cubeEdge = cubeEdge;
        this.points = points;
    }

    public double getCubeEdge() {
        return cubeEdge;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setCubeEdge(double cubeEdge) {
        this.cubeEdge = cubeEdge;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cube cube = (Cube) o;
        return Double.compare(cube.cubeEdge, cubeEdge) == 0 &&
                Objects.equals(points, cube.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cubeEdge, points);
    }
}
