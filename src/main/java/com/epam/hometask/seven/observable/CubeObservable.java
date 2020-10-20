package com.epam.hometask.seven.observable;


import com.epam.hometask.seven.model.Cube;
import com.epam.hometask.seven.model.Point;

import java.util.ArrayList;
import java.util.List;


public class CubeObservable extends Cube implements Observable {

    private int id;
    private List<Observer> observers = new ArrayList<>();

    public CubeObservable(int id, Cube cube) {
        super(cube.getCubeEdge(), cube.getPoints());
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setEdge(Double edge) {
        super.setCubeEdge(edge);
        notifyObservers();
    }

    void notifyObservers() {
        for (Observer observer : observers) {
            observer.notify(this);
        }

    }

}
