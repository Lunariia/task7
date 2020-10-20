package com.epam.hometask.seven.model;

import java.util.List;
import java.util.Objects;

public class Plane {

    private final List<Point> points;

    public Plane(List<Point> points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Plane plane = (Plane) o;
        return Objects.equals(points, plane.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
